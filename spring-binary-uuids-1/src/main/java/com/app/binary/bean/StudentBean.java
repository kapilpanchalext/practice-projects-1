package com.app.binary.bean;

import java.io.Serializable;
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
public class StudentBean implements Serializable{

	private static final long serialVersionUID = -3646167250113840681L;

	@Id
	@Builder.Default
	private String id = UUID.randomUUID().toString();	
	private String firstName;
	private String lastName;
	private Short age;
}
