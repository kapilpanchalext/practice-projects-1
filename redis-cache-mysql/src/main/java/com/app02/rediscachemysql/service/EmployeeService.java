package com.app02.rediscachemysql.service;

import org.springframework.data.domain.Page;

import com.app02.rediscachemysql.model.Employee;

public interface EmployeeService {

	Employee findEmployeeById(Long id);

    Page<Employee> getAllEmployees(Integer page, Integer size);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}