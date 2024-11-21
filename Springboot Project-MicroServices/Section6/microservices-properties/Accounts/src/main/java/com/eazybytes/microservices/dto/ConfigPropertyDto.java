package com.eazybytes.microservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Schema(name = "ConfigPropertyDto",description = "requestProperties")
@ConfigurationProperties(prefix = "accounts")
public record ConfigPropertyDto(String name, Map<String,String> contactDetails, List<String> landLine) {
}
