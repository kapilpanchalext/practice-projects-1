package com.app05.userserviceredis.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.app05.userserviceredis.model.UserDetails;
import com.app05.userserviceredis.repo.UserRepo;

import lombok.var;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public UserDetails saveUser(UserDetails userDetails) {
		return repo.saveAndFlush(userDetails);
	}

	@Override
	public UserDetails getUserDetailsById(Long userId) {
		var key = "user_" + userId;
        final ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            final UserDetails post = (UserDetails) operations.get(key);
            System.err.println("EmployeeServiceImpl.findEmployeeById() : cache post >> " + post.toString());
            return post;
        }
        final Optional<UserDetails> userDetails = repo.findById(userId);
        if(userDetails.isPresent()) {
            operations.set(key, userDetails.get(), 10000, TimeUnit.SECONDS);
            System.err.println("EmployeeServiceImpl.findEmployeeById() : cache insert >> " + userDetails.get().toString());
            return userDetails.get();
        } else {
            throw new RuntimeException("Error");
        }
	}
}