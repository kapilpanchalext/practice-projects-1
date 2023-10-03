package com.app.redis.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.redis.bean.Todo;
import com.app.redis.repo.TodoRepo;

@Configuration
public class DataConfig {

	@Bean
	CommandLineRunner loadData(TodoRepo repo) {
	
		return args -> {
			repo.deleteAll();
			repo.save(Todo.builder().title("Wake Up").build());
			repo.save(Todo.builder().title("Fall out of Bed").build());
			repo.save(Todo.builder().title("Drag a comb across your head").build());
		};
	}
}
