package com.ubs.auth.hub.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ubs.auth.hub")
@EnableJpaRepositories(basePackages = { "com.ubs.auth.hub.repository" })
@EntityScan(basePackages = { "com.ubs.auth.hub.entity" })
public class UbsAuthHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbsAuthHubApplication.class, args);
	}

}
