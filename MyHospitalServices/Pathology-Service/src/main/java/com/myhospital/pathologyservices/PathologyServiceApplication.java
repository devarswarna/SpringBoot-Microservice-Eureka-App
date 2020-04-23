package com.myhospital.pathologyservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PathologyServiceApplication {
	
    @LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(PathologyServiceApplication.class, args);
	}

}
