package com.app.binary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBinaryUuids1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBinaryUuids1Application.class, args);
	}

}
