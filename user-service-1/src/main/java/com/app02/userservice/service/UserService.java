package com.app02.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.client.RestTemplate;

import com.app02.userservice.VO.Department;
import com.app02.userservice.VO.ResponseTemplateVO;
import com.app02.userservice.model.UserDetails;
import com.app02.userservice.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	public RestTemplate restTemplate;
		
	public UserDetails saveUser(@RequestBody UserDetails userDetails) {		
		return repo.saveAndFlush(userDetails);
	}

	public UserDetails findUserById(Long userId) {
		return repo.findById(userId).get();
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		
		ResponseTemplateVO vo = new ResponseTemplateVO();		
		UserDetails userDetails = repo.findById(userId).get();
		
		Department department = restTemplate.getForObject("http://localhost:9001/departments/" + userDetails.getUserId() , Department.class);
		
		vo.setUserDetails(userDetails);
		vo.setDepartment(department);
		
		return vo;
	}
}
