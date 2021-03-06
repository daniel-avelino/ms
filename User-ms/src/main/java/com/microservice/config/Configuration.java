package com.microservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.microservice.entities.User;
import com.microservice.repositories.UserRepository;
import com.microservice.services.UserService;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner{

	@Autowired
	private UserRepository repository; 
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(1L,"daniel","daniel_avelino@outlook.com","123456");
		repository.saveAndFlush(user1);
	}

	
}
