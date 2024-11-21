package com.example.Cards.dto;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
public record CardsContactDto(String name, Map<String,String> contactDetails, List<String> landLine) {
}
