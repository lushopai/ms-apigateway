package com.techserv.arrivingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.retry.annotation.CircuitBreaker;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ArrivingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArrivingServiceApplication.class, args);
	}

}
