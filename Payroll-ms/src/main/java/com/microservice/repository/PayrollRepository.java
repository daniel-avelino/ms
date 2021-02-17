package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entities.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

	Payroll findByWorkerId(Long id);
}
