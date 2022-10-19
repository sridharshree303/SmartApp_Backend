package com.cg.pravin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.pravin.modal.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Employee findByEmail(String email);
	
}
