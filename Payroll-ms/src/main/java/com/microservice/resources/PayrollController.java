package com.microservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entities.Payroll;
import com.microservice.services.PayrollServices;

@RestController
@RequestMapping(path = "/payments")
public class PayrollController {

	@Autowired
	private PayrollServices services;

	@GetMapping
	private ResponseEntity<List<Payroll>> findAll() {
		return ResponseEntity.ok().body(services.findAll());
	}

	@GetMapping(path = "/{id}")
	private ResponseEntity<Payroll> findById(@PathVariable long id) {
		return ResponseEntity.ok().body(services.findById(id));
	}

	@PostMapping(path = "/{id}/{days}/{dailyIncome}")
	private ResponseEntity<Payroll> insertPayment(@PathVariable int days, @PathVariable double dailyIncome,
			@PathVariable Long id) {
		services.newPayment(days, id);
		return new ResponseEntity<Payroll>(HttpStatus.CREATED);
	}

}
