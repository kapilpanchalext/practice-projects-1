package com.app05.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MainModuleRedis2Application {

	public static void main(String[] args) {
		SpringApplication.run(MainModuleRedis2Application.class, args);
	}

}
