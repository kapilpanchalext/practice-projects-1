package com.app.validation.bean;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonBean {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private Byte age;
	private String programName;
}