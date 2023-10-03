package com.app.unittest.bean;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentBean {

	@Id
	@Builder.Default
	private UUID studentId = UUID.randomUUID();
	
	private String firstName;
	
	private String lastName;
	
	private long age;
	
	private String programName;
}
