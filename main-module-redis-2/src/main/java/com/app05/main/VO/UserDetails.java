package com.app05.main.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
}