package com.redisexample.config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.redisexample.model.Student;
import com.redisexample.repository.StudentRepository;

@Configuration
public class StudentConfig {

	@Autowired
	private StudentRepository studentRepo;	
	
    @Bean
    CommandLineRunner runner (){
        return args -> {
			Student student = new Student("John Doe");			
			
			try {
				System.err.println("SAVED STUDENT: " + student);
				studentRepo.saveAll(Stream.of(student).collect(Collectors.toList()));
				List<Student> retrievedStudent = studentRepo.findAll();
				System.err.println("RETRIEVED STUDENT: " + retrievedStudent);
			} catch (Exception e) {
				e.printStackTrace();
			}

		};
	}
}