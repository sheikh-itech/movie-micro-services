package com.jpa.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.jpa.service.repositories"})
@EntityScan(basePackages = {"com.jpa.service.beans"})
public class SpringJpaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaServiceApplication.class, args);
	}

}
