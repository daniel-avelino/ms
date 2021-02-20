package com.microservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entities.User;
import com.microservice.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(path = "/{email}")
	public ResponseEntity<User> findByEmail(@PathVariable String email) {
		return ResponseEntity.ok().body(service.findByEMail(email));
	}

	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		service.insertUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
}
