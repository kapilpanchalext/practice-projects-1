package com.app05.userserviceredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserServiceRedis2Application {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceRedis2Application.class, args);
	}

}
