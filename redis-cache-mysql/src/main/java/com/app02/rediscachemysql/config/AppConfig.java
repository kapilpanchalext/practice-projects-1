package com.app02.rediscachemysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.app02.rediscachemysql.model.Employee;
import com.app02.rediscachemysql.repository.EmployeeRepository;

@Component
public class AppConfig {

	@Autowired
	private EmployeeRepository repo;

	@Bean
	private CommandLineRunner runner() {
		return args -> {
			Employee employee1 = Employee.builder()
					.name("Employee 1")
					.age(123)
					.salary(123.123)
					.build();			
			repo.saveAndFlush(employee1);
		};
	}
}