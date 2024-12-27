package com.example.apigateway;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ApiGatewayController {

    private static final Logger logger = LoggerFactory.getLogger(ApiGatewayController.class);

    @Retry(name = "fallbackretry", fallbackMethod = "fallBackMethod")
    @GetMapping("/fallbackPath")
    public Mono<String> fallbackMethod() {
        throw new RuntimeException();
        //return Mono.just("API delay in Accounts Services");
    }

    public Mono<String> fallBackMethod() {
        // throw new RuntimeException();
        logger.debug("getBuildInfoFallback() method Invoked");
        return Mono.just("API delay in Accounts Services");
    }
}
