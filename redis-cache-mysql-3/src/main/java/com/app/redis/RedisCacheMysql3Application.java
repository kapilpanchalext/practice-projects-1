package com.app.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheMysql3Application {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheMysql3Application.class, args);
	}

}
