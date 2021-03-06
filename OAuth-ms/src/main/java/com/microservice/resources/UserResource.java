package com.microservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entities.User;
import com.microservice.services.OAuthService;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

	@Autowired
	private OAuthService service;

	@GetMapping(path = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok().body(service.findByEmail(email));
	}
}
