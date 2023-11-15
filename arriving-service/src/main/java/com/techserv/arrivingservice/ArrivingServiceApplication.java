package com.techserv.arrivingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ArrivingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArrivingServiceApplication.class, args);
	}

}
