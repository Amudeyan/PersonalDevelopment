package com.example.apigateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = {"filter","com.example.apigateway"})
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
								.addResponseHeader("ResponseTime",LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("AccountCircuitBreaker")
										.setFallbackUri("forward:/fallbackPath"))
										.retry(retryConfig -> retryConfig.setMethods(HttpMethod.GET)
												.setBackoff(Duration.ofMillis(1000),Duration.ofMillis(1200),2,true)
												.setRetries(3))
//										.requestRateLimiter(ratelimit->
//												ratelimit.setRateLimiter(redisRateLimiter()
//														).setKeyResolver(userKeyResolver())
//										)

								)
						.uri("lb://ACCOUNTS"))
				.route(predicateSpec -> predicateSpec.path("/eazybank/cards/**" )
						.filters(gatewayFilterSpec -> gatewayFilterSpec
								.rewritePath("eazybank/cards/?(?<remaining>.*)","/${remaining}")
								.retry(retryConfig -> retryConfig.setMethods(HttpMethod.GET)
										.setBackoff(Duration.ofMillis(100),Duration.ofMillis(1000),2,true)
										.setRetries(3))
								//.addRequestHeader("RequestTime", LocalDateTime.now().toString())
								.addResponseHeader("ResponseTime",LocalDateTime.now().toString()))
						.uri("lb://CARDS"))
				.route(predicateSpec -> predicateSpec.path("/eazybank/loans/**" )
						.filters(gatewayFilterSpec -> gatewayFilterSpec
								.rewritePath("eazybank/loans/?(?<remaining>.*)","/${remaining}")
								//.addRequestHeader("RequestTime", LocalDateTime.now().toString())
								.addResponseHeader("ResponseTime",LocalDateTime.now().toString())
								.retry(retryConfig -> retryConfig.setMethods(HttpMethod.GET)
										.setBackoff(Duration.ofMillis(100),Duration.ofMillis(1000),2,true)
										.setRetries(3)))
						.uri("lb://LOANS"))

				.build();
	}
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(10)).build()).build());
	}


/*	@Bean
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(1, 1, 1);
	}



	@Bean
	KeyResolver userKeyResolver() {
		return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
				.defaultIfEmpty("anonymous");
	}*/


}
