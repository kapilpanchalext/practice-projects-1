package com.app.redis.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.app.redis.bean.Employee;
import com.app.redis.repo.EmployeeRepository;

import lombok.var;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private RedisTemplate<String, Employee> redisTemplate;

	public Employee saveEmployee(Employee employee) {
		
		Employee status = repo.saveAndFlush(employee);
		
		var key = "employee_" + status.getId();
        final ValueOperations<String, Employee> operations = redisTemplate.opsForValue();
        operations.set(key, employee, 10, TimeUnit.DAYS);
        System.err.println("cache insert at save >> " + employee.toString());	
		return status;
	}

	public Employee getEmployeeById(Long id) {		
		return null;
	}
}
