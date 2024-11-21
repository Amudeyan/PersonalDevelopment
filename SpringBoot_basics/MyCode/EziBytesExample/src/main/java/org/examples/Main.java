package org.examples;

import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com.repository")
@EntityScan(basePackages = "com.data")
@EnableJpaAuditing
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ss =SpringApplication.run(Main.class,args);
      //  Arrays.stream(ss.getBeanDefinitionNames()).forEach(System.out::println);
    }
}