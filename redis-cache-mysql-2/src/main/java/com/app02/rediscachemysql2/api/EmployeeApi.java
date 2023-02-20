package com.app02.rediscachemysql2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app02.rediscachemysql2.model.Employee;
import com.app02.rediscachemysql2.service.EmployeeService;

@RestController
@RequestMapping(path = "/api")
public class EmployeeApi {

	@Autowired
	private EmployeeService service;
	
	@PostMapping(path = "/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		boolean employeeSaved = service.saveEmployee(employee);
		return "Employee Saved Successfully: " + employeeSaved;
	}
		
	@GetMapping(path = "/employees/{id}")	
	public Employee getEmployeeById(@PathVariable ("id") Long id) {
		System.err.println("Employee from Database:: " + id);
		return service.getEmployeeById(id);
	}
}