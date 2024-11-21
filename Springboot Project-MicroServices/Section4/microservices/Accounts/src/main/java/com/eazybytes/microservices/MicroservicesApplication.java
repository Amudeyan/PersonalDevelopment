package com.eazybytes.microservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts API",
				description = "microservices for Accounts API's",
				version = "1.0",
				contact =@Contact(
						name = "Arav",
						email = "aravinthcit.ece@gmail.com",
						url = "https://mail.google.com/mail/u/0/#inbox"),
				license = @License(
						name = "Apache 2.0",
						url = "https://parivahan.gov.in/parivahan/?prvcaeprm=1699543432068")
		),
		externalDocs = @ExternalDocumentation(
				url = "https://www.youtube.com/",
		description = "microservices Documentation")
)
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}

}
