package com.app03.thymeleaf1.service;


import java.util.List;
import java.util.Optional;
import com.app03.thymeleaf1.model.Employee;


public interface EmployeeService {

	Optional<List<Employee>> getAllEmployees();

	boolean saveEmployee(Employee employee);

	Employee findEmployeeById(Long employeeId);
}