package com.eazybytes.microservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Schema(name = "ConfigPropertyDto",description = "requestProperties")
@ConfigurationProperties(prefix = "accounts")
@Getter @Setter
public class ConfigPropertyDto {
    private String name;
   private  Map<String,String> contactDetails;
   private List<String> landLine;
}
