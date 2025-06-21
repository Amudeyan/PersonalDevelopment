package com.configuration.secondb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Application")
@NoArgsConstructor @AllArgsConstructor
@Data
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer applicationNo;
    private String mailId;
    private String applicationFlow;
    private LocalDate dob;
    private Integer mobileNo;
    private String channel;
    private String channelPartner;
    private String productCode;
}
