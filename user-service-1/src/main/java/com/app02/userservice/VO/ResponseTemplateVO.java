package com.app02.userservice.VO;

import com.app02.userservice.model.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	private UserDetails userDetails;
	private Department department;
}
