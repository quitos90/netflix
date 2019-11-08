package com.netflix.usersdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class UsersDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersDbApplication.class, args);
	}

}
