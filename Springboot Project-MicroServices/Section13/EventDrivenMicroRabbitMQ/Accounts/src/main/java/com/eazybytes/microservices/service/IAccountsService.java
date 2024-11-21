package com.eazybytes.microservices.service;

import com.eazybytes.microservices.dto.CustomerDto;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);

    boolean updateCommunicationStatus(Long accountNumber);


}
