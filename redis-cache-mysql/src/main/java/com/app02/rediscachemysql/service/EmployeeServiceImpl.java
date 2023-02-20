package com.app02.rediscachemysql.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.app02.rediscachemysql.exception.ResourceNotFoundException;
import com.app02.rediscachemysql.model.Employee;
import com.app02.rediscachemysql.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.RequiredArgsConstructor;
import lombok.var;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	private RedisTemplate<String, Employee> redisTemplate;

    @Override
    public Employee findEmployeeById(Long id) {
    	
    	System.err.println("INSIDE FIND EMPLOYEE BY ID SERVICE IMPL: " + id);
        var key = "emp_" + id;
        System.err.println("VAR KEY: " + key);
        
        final ValueOperations<String, Employee> operations = redisTemplate.opsForValue();
        System.err.println("REDIS TEMPLATE: " + operations);
        
        final boolean hasKey = redisTemplate.hasKey(key);
        
        if (hasKey) {
            final Employee post = operations.get(key);
            return post;
        }
        
        final Optional<Employee> employee = employeeRepository.findById(id);
        
        if(employee.isPresent()) {
            operations.set(key, employee.get(), 10, TimeUnit.SECONDS);
            return employee.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Page<Employee> getAllEmployees(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(
                Sort.Order.desc("id")));
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        final String key = "emp_" + employee.getId();
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        final String key = "emp_" + id;
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
        final Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.delete(employee.get());
        } else {
            throw new ResourceNotFoundException();
        }
    }	
}
