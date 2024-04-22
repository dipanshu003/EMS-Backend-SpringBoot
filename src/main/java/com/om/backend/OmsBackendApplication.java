package com.om.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.om.backend.model.Address;

@SpringBootApplication
public class OmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsBackendApplication.class, args);
		System.out.println("Application Started...");
	}

}
