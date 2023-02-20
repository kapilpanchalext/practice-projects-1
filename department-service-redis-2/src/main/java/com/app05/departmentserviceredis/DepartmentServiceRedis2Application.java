package com.app05.departmentserviceredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DepartmentServiceRedis2Application {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceRedis2Application.class, args);
	}

}
