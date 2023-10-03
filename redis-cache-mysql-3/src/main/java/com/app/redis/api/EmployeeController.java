package com.app.redis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.redis.bean.Employee;
import com.app.redis.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping(path = "/add")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee employeeSaved = service.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(employeeSaved);
	}
		
	@GetMapping(path = "/employee/{id}")	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") Long id) {
		System.err.println("Employee from Database: " + id);
		Employee employeeSaved = service.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeSaved);
	}
}