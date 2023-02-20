package com.app05.main.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDetails {

	private Long departmentId;	
	private String departmentName;	
	private String departmentAddress;	
	private String departmentCode;
}