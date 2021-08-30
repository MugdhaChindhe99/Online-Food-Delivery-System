package com.cg.ofd.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerModuleApplication.class, args);
	}

}
