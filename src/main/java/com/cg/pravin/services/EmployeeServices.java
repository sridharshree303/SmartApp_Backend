package com.cg.pravin.services;

import com.cg.pravin.modal.Employee;

public interface EmployeeServices {
	
	public Employee register(Employee employee);
	
	public Employee login(Employee employee);

	public String logout(Employee emp);
	
}
