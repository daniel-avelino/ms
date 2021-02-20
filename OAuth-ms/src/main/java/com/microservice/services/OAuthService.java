package com.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.entities.User;
import com.microservice.feignclients.UserFeignClient;

public class OAuthService {

	@Autowired
	private UserFeignClient userFeign;

	public User findByEmail(String email) {
		User user = userFeign.findByEmail(email).getBody();
		return user;
	}

}
