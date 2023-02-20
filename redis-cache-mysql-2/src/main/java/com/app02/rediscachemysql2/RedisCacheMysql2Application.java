package com.app02.rediscachemysql2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheMysql2Application {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheMysql2Application.class, args);
	}
}