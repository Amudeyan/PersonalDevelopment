package com.eazybytes.microservices.controller;

import com.eazybytes.microservices.constants.AccountsConstants;
import com.eazybytes.microservices.dto.ConfigPropertyDto;
import com.eazybytes.microservices.dto.CustomerDto;
import com.eazybytes.microservices.dto.ErrorResponseDto;
import com.eazybytes.microservices.dto.ResponseDto;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.eazybytes.microservices.service.IAccountsService;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(name = "CRUD Accounts", description = "CRUD API's fpr Accounts Controller")
public class AccountsController {
    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

    private IAccountsService iAccountsService;
    private ConfigPropertyDto configPropertyDto;

    @Operation(summary = "Create Account", description = "Create Account for Customer")
    @ApiResponse(
            responseCode = "201",
            description = "Suucess"

    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto responseDto) {

        iAccountsService.createAccount(responseDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(summary = "Fetch Account", description = "Fetch Account for Customer")
    @ApiResponse(
            responseCode = "200",
            description = "Suucess"

    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam
                                                    @Pattern(
                                                            regexp = "(^$|[0-9]{10})",
                                                            message = "Please provide  10 digit number") String mobileNumber) {

        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(summary = "Update Account", description = "Update Account for Customer")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Suucess"

    ), @ApiResponse(
            responseCode = "417",
            description = "Update operation failed. Please try again or contact Dev team",
            content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )

    ), @ApiResponse(
            responseCode = "500",
            description = "Server Error",
            content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )

    )})
    @PatchMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {

        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(summary = "Deiete Account", description = "Delete Account for Customer")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Suucess"

    ), @ApiResponse(
            responseCode = "417",
            description = "Delete operation failed. Please try again or contact Dev team"

    ), @ApiResponse(
            responseCode = "500",
            description = "Server Error",
            content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )

    )})
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam
                                                     @Pattern(regexp = "(^$|[0-9]{10})",
                                                             message = "Please provide  10 digit number") String mobileNumber) {
        boolean isCustomerDto = iAccountsService.deleteAccount(mobileNumber);
        if (isCustomerDto) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }
    }

    @Operation(summary = "Get properties for Accounts", description = "Get properties for Accounts")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Suucess"

    )})
    @Retry(name = "getProperties", fallbackMethod = "fallbackMethod")
    @GetMapping("/contact-info")
    public ResponseEntity<ConfigPropertyDto> getProperties() {
        logger.debug("contact-info method Invoked");
        throw new RuntimeException();
       /* return ResponseEntity
                .status(HttpStatus.OK)
                .body(configPropertyDto);*/
    }

    public ResponseEntity<ConfigPropertyDto> fallbackMethod(Throwable throwable) {
        logger.debug("getBuildInfoFallback() method Invoked");
        //throw new RuntimeException();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(configPropertyDto);
    }
}
