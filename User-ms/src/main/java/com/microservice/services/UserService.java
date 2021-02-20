package com.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entities.User;
import com.microservice.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findByEMail(String email) {
		return repository.findByEmail(email);
	}

	public void insertUser(User user) {
		repository.save(user);

	}
}
