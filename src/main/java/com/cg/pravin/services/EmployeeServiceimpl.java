package com.cg.pravin.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pravin.modal.Employee;
import com.cg.pravin.repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements EmployeeServices {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceimpl.class);

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private Sessions sessions;

	@Override
	public Employee register(Employee employee) {
		LOG.info("Register service");
		
		// Id generator
		Integer baseId = 10000;
		List<Employee> list = empRepository.findAll();
		Integer len = list.size();
		
		if (len != 0) {
			Employee lastuser = list.get(--len);
			Integer lastId = lastuser.getEmpId();
			Integer newEmpId = ++lastId;
			employee.setEmpId(newEmpId);
			lastuser = null;
			len = 0;lastId = 0;
		}else {
			Integer newEmpId = baseId + 1;
			employee.setEmpId(newEmpId);
		}
		
		LOG.info("ID assigned");
		return empRepository.save(employee);
	}

	@Override
	public Employee login(Employee employee) {
		LOG.info("Login Service");
		Employee emp = empRepository.findByEmail(employee.getEmail());
		if (null != emp) {
			Sessions.setLoginStatus(emp);
			Employee sessiondata = empRepository.save(emp);
			LOG.info("Data found");
			return sessiondata;
		} else {
			LOG.info("wrong credintials");
			throw new RuntimeException();
		}
	}

	@Override
	public String logout(Employee emp) {
		LOG.info("LogOut Service");
		Employee temp = empRepository.findByEmail(emp.getEmail());
		Sessions.setLogoutStatus(temp);
		empRepository.save(temp);
		temp = null;
		LOG.info("Session Closed");
		return "Logout Successfull";
	}

	public List<Employee> allData() {
		LOG.info("Register service");
		return empRepository.findAll();
	}

}
