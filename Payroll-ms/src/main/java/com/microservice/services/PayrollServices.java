package com.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entities.Payroll;
import com.microservice.repository.PayrollRepository;

@Service
public class PayrollServices {

	@Autowired
	private PayrollRepository repository;

	public List<Payroll> findAll() {
		return repository.findAll();
	}
	
	public Payroll findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void newPayment(Payroll payroll) {
		repository.save(payroll);
	}
	
	public void deletePayment(Long id) {
		repository.deleteById(id);
	}
}
