package com.app05.departmentserviceredis.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.app05.departmentserviceredis.model.DepartmentDetails;
import com.app05.departmentserviceredis.repo.DepartmentRepo;

import lombok.var;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public DepartmentDetails saveDepartment(DepartmentDetails departmentDetails) {		
		return repo.saveAndFlush(departmentDetails);
	}

	@Override
	public DepartmentDetails getDepartmentById(Long departmentId) {
		var key = "department_" + departmentId;
        final ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            final DepartmentDetails post = (DepartmentDetails) operations.get(key);
            System.err.println("DepartmentServiceImpl.getDepartmentById() : cache post >> " + post.toString());
            return post;
        }
        final Optional<DepartmentDetails> department = repo.findById(departmentId);
        if(department.isPresent()) {
            operations.set(key, department.get(), 10000, TimeUnit.SECONDS);
            System.err.println("DepartmentServiceImpl.getDepartmentById() : cache insert >> " + department.get().toString());
            return department.get();
        } else {
            throw new RuntimeException("Error");
        }
	}
}