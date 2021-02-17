package com.microservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.microservice.services.PayrollServices;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

	@Autowired
	private PayrollServices services;

	@Override
	public void run(String... args) throws Exception {
		services.newPayment(10, 1);
	}

}
