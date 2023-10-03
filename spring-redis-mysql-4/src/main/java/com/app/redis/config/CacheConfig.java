package com.app.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class CacheConfig {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
//	@Bean
//	CacheManager cacheManager() {
//		RedisCacheManager manager = new RedisCacheManager(redisTemplate);
//		return manager;		
//	}
}
