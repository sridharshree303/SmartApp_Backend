package com.cg.pravin.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pravin.modal.Employee;
import com.cg.pravin.services.EmployeeServiceimpl;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServiceimpl employeeServiceimpl;
	
	@GetMapping("/")
	public String message() {
		LOG.info("message printed");
		System.out.println("Sridhar");
		return "Sridhar Kolluru";
	}
	
	@PostMapping("/register")
	public Employee registerEmployee(@RequestBody Employee employee) {
		LOG.info("register employee controller");
		Employee emp = employeeServiceimpl.register(employee);
		LOG.info("response returned");
		return emp;
	}
	
	@PostMapping("/login")
	public Employee loginEmployee(@RequestBody Employee employee) {
		LOG.info("Login controller");
		Employee emp = employeeServiceimpl.login(employee);
		LOG.info("response returned");
		return emp;
	}
	
	@PostMapping("/logout")
	public String logoutEmployee(@RequestBody Employee employee) {
		LOG.info("Logout Controller");
		String str = employeeServiceimpl.logout(employee);
		LOG.info(str);
		return str;
	}
	
	@GetMapping("/getall")
	public List<Employee> employeeData(){
		LOG.info("Employee Controller");
		ArrayList<Employee> data = (ArrayList<Employee>) employeeServiceimpl.allData();
		return data;
	}
}







