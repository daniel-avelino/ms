package com.microservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entities.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
