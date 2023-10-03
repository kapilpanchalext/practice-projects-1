package com.app03.thymeleaf1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app03.thymeleaf1.model.Employee;
import com.app03.thymeleaf1.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Optional<List<Employee>> getAllEmployees() {		
		Optional<List<Employee>> employeeList = (Optional.of(repo.findAll()));		
		return employeeList;
	}

	@Override
	public boolean saveEmployee(Employee employee) {		
		boolean status = true;
		Employee newEmployee = repo.saveAndFlush(employee);
		if(newEmployee == null) {
			status = false;
		}
		return status;
	}

	@Override
	public Employee findEmployeeById(Long employeeId) {
		Employee employee = repo.findById(employeeId).get();
		return employee;
	}
}