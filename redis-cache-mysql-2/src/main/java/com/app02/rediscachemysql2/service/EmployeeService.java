package com.app02.rediscachemysql2.service;

//https://github.com/r4lly99/spring-mysql-redis/blob/main/src/main/java/com/irsyad/springmysqlredis/service/impl/EmployeeServiceImpl.java

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.app02.rediscachemysql2.model.Employee;
import com.app02.rediscachemysql2.repo.EmployeeRepository;

import lombok.var;

@Service
public class EmployeeService {
	
	private boolean hasKey = false;
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public boolean saveEmployee(Employee employee) {
		repo.save(employee);
		return true;
	}
	
//	public Employee getEmployeeById(Long id) {
//		
//		Employee employee1 = repo.findById(id).get();
//
//		String key = "emp_" + id;
//		System.err.println("KEY: " + key);
//		
//		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
//		operations.set(key, employee1, 10000, TimeUnit.SECONDS);
//		System.err.println("OPERATIONS: " + operations.get(key));
//		
//		employee1 = (Employee)operations.get(key);
//		
//		boolean hasKey = redisTemplate.hasKey(key);
//		System.err.println("HAS KEY: " + hasKey);
//		return (Employee)operations.get(key);
//	}
	
	public Employee getEmployeeById(Long id) {
		
		var key = "emp_" + id;
        final ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            final Employee post = (Employee) operations.get(key);
            System.err.println("EmployeeServiceImpl.findEmployeeById() : cache post >> " + post.toString());
            return post;
        }
        final Optional<Employee> employee = repo.findById(id);
        if(employee.isPresent()) {
            operations.set(key, employee.get(), 10, TimeUnit.SECONDS);
            System.err.println("EmployeeServiceImpl.findEmployeeById() : cache insert >> " + employee.get().toString());
            return employee.get();
        } else {
            throw new RuntimeException("Error");
        }
	}
}