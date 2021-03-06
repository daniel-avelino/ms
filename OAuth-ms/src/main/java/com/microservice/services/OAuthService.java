package com.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.entities.User;
import com.microservice.feignclients.UserFeignClient;

@Service
public class OAuthService implements UserDetailsService {

	@Autowired
	private UserFeignClient userFeign;

	public User findByEmail(String email) {
		User user = userFeign.findByEmail(email).getBody();
		if (user == null) {
			throw new IllegalArgumentException("User not found!" + email);
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeign.findByEmail(username).getBody();
		if (user == null) {
			throw new UsernameNotFoundException("User not found!" + username);
		}
		return user;
	}

}
