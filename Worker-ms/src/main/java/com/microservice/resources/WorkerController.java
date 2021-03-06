package com.microservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entities.Worker;
import com.microservice.services.WorkerService;

@RestController
@RequestMapping(path = "/workers")
public class WorkerController {

	@Autowired
	private WorkerService workerServices;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok().body(workerServices.findAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(workerServices.findById(id));
	}

	@PostMapping
	public ResponseEntity<Worker> insert(@RequestBody Worker worker) {
		workerServices.insertWorker(worker);
		return new ResponseEntity<Worker>(HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Worker> delete(@PathVariable Long id) {
		workerServices.deleteWorker(id);
		return new ResponseEntity<Worker>(HttpStatus.OK);
	}

}
