package com.app02.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app02.departmentservice.model.Department;
import com.app02.departmentservice.repo.DepartmentRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
		
	@Autowired
	private DepartmentRepo repo;

	public Department saveDepartment(Department department) {
		
		return repo.saveAndFlush(department);
	}

	public Department findDepartmentById(Long departmentId) {
		
		return repo.findById(departmentId).get();
	}
}
