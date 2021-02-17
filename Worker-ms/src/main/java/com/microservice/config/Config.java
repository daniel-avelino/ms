package com.microservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.microservice.entities.Worker;
import com.microservice.services.WorkerService;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

	@Autowired
	private WorkerService services;

	@Override
	public void run(String... args) throws Exception {

		services.insertWorker(new Worker(null, "Daniel", 1500.00));
		services.insertWorker(new Worker(null, "Lidiana", 500.00));
		services.insertWorker(new Worker(null, "Test", 3500.00));

	}

}
