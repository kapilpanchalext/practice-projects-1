package com.app05.main.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.app05.main.model.MainData;
import com.app05.main.repo.MainRepo;

import lombok.var;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainRepo repo;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public MainData saveMainData(MainData data) {		
		return repo.saveAndFlush(data);
	}

	@Override
	public MainData getMainDataById(Long mainId) {		
		var key = "main_" + mainId;
        final ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            final MainData post = (MainData) operations.get(key);
            System.err.println("EmployeeServiceImpl.findEmployeeById() : cache post >> " + post.toString());
            return post;
        }
        final Optional<MainData> employee = repo.findById(mainId);
        if(employee.isPresent()) {
            operations.set(key, employee.get(), 10000, TimeUnit.SECONDS);
            System.err.println("EmployeeServiceImpl.findEmployeeById() : cache insert >> " + employee.get().toString());
            return employee.get();
        } else {
            throw new RuntimeException("Error");
        }		
	}
}