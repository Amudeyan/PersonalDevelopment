package com.example.message.dto;

import org.springframework.stereotype.Component;


public record AccountsMsgDto(Long accountNumber,String name,String email,String mobileNumber) {
}
