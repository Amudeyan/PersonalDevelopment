package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = {"filter"})
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(predicateSpec -> predicateSpec.path("/eazybank/accounts/**" )
						.filters(gatewayFilterSpec -> gatewayFilterSpec
								.rewritePath("eazybank/accounts/?(?<remaining>.*)","/${remaining}")
								//.addRequestHeader("RequestTime", LocalDateTime.now().toString())
								.addResponseHeader("ResponseTime",LocalDateTime.now().toString()))
						.uri("lb://ACCOUNTS"))
				.route(predicateSpec -> predicateSpec.path("/eazybank/cards/**" )
						.filters(gatewayFilterSpec -> gatewayFilterSpec
								.rewritePath("eazybank/cards/?(?<remaining>.*)","/${remaining}")
								//.addRequestHeader("RequestTime", LocalDateTime.now().toString())
								.addResponseHeader("ResponseTime",LocalDateTime.now().toString()))
						.uri("lb://CARDS"))
				.route(predicateSpec -> predicateSpec.path("/eazybank/loans/**" )
						.filters(gatewayFilterSpec -> gatewayFilterSpec
								.rewritePath("eazybank/loans/?(?<remaining>.*)","/${remaining}")
								//.addRequestHeader("RequestTime", LocalDateTime.now().toString())
								.addResponseHeader("ResponseTime",LocalDateTime.now().toString()))
						.uri("lb://LOANS"))

				.build();
	}

}
