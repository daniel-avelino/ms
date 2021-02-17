package com.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entities.Worker;
import com.microservice.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public List<Worker> findAll() {
		return repository.findAll();
	}

	public Worker findById(Long id) {
		return repository.findById(id).get();
	}

	public void insertWorker(Worker worker) {
		repository.save(worker);
	}

	public void deleteWorker(Long id) {
		repository.deleteById(id);
	}

}
