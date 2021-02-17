package com.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entities.Payroll;
import com.microservice.entities.Worker;
import com.microservice.feignclients.WorkerFeignClient;
import com.microservice.repository.PayrollRepository;

@Service
public class PayrollServices {

	@Autowired
	private PayrollRepository repository;

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public List<Payroll> findAll() {
		return repository.findAll();
	}

	public Payroll findById(Long id) {
		return repository.findByWorkerId(id);
	}

	public void newPayment(int days, long id) {
		Worker worker = workerFeignClient.findById(id).getBody();
		Payroll payment = new Payroll(null, worker.getName(), worker.getDailyIncome(), days, worker.getId());
		repository.save(payment);
	}

	public void deletePayment(Long id) {
		repository.deleteById(id);
	}
}
