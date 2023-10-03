package com.app.kafka.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentBean {

	private String studentId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String programName;
}
