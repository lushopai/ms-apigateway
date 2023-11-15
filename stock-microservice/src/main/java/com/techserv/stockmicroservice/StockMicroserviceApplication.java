package com.techserv.stockmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMicroserviceApplication.class, args);
	}

}
