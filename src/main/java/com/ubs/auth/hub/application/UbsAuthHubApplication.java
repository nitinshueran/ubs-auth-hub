package com.ubs.auth.hub.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ubs.auth.hub")
public class UbsAuthHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbsAuthHubApplication.class, args);
	}

}
