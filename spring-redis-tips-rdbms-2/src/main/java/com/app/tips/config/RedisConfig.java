package com.app.tips.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisConfig {

	@Bean
	CacheManager cacheManager(RedisConnectionFactory cf) {
		return RedisCacheManager.builder(cf).build();
	}
}
