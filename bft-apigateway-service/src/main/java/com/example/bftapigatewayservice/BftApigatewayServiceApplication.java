package com.example.bftapigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BftApigatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BftApigatewayServiceApplication.class, args);
	}

}
