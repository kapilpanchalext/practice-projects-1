package com.app.badge.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExamRegistrationBean {
	private String sapid; 
	private String program; 
	private String month; 
	private int year; 
	private int sem; 
	private int consumerProgramStructureId;
}
