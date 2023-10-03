package com.app.redis.bean;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "student")
public class StudentBean {

	@Id
	@Builder.Default
	private UUID studentId = UUID.randomUUID();
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private String gender;
	
	private String programName;
}
