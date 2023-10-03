package com.app.tips.bean;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "student")
public class Student implements Serializable {

	@Id
	@Builder.Default
	private UUID studentId = UUID.randomUUID();
	
	@Indexed
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	@Reference
	private List<Program> programs;
}
