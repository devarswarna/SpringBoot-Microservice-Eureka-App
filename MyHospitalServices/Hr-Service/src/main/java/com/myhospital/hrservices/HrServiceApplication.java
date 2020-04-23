package com.myhospital.hrservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrServiceApplication {
	
    @LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}

}
