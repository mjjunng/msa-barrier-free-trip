package com.example.bftmainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BftMainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BftMainServiceApplication.class, args);
	}

}
