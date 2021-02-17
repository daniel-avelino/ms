package com.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
