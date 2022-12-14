package com.movie.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

	//This is Only Rest Template
	/*
	@Bean
	public RestTemplate userDefinedMethodName() {
		
		return new RestTemplate();
	} */
	
	@Bean
	@LoadBalanced	//This support Cloud/Eureka for Micro Service Communication
	public RestTemplate userDefinedMethodName() {
		
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(3000);
		
		return new RestTemplate(factory);
	}
	
	@Bean
	public WebClient.Builder userDefinedBuilder(){
		return WebClient.builder();
	}
}
