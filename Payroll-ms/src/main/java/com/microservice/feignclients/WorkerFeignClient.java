package com.microservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.entities.Worker;

@Component
@FeignClient(name = "worker-ms", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping(path="/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);

}
