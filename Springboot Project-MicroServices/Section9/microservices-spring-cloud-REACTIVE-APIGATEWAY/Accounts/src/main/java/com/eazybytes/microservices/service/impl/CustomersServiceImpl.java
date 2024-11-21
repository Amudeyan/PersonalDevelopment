package com.eazybytes.microservices.service.impl;

import com.eazybytes.microservices.dto.AccountsDto;
import com.eazybytes.microservices.dto.CardsDto;
import com.eazybytes.microservices.dto.CustomerDetailsDto;
import com.eazybytes.microservices.dto.LoansDto;
import com.eazybytes.microservices.entity.Accounts;
import com.eazybytes.microservices.entity.Customer;
import com.eazybytes.microservices.exception.ResourceNotFoundException;
import com.eazybytes.microservices.mapper.AccountsMapper;
import com.eazybytes.microservices.mapper.CustomerMapper;
import com.eazybytes.microservices.repository.AccountsRepository;
import com.eazybytes.microservices.repository.CustomerRepository;
import com.eazybytes.microservices.service.ICustomersService;
import com.eazybytes.microservices.service.clients.CardsFeignClient;
import com.eazybytes.microservices.service.clients.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}