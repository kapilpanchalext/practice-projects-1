package com.app.tips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisTipsRdbms3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisTipsRdbms3Application.class, args);
	}

}
