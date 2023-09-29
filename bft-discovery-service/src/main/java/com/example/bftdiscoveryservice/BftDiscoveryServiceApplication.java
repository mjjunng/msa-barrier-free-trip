package com.example.bftdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BftDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BftDiscoveryServiceApplication.class, args);
	}

}
