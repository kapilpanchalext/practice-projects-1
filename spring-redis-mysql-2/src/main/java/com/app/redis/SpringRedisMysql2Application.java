package com.app.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisMysql2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisMysql2Application.class, args);
	}

}
