package com.app02.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app02.departmentservice.model.Department;
import com.app02.departmentservice.repo.DepartmentRepo;

@Service
public class DepartmentService {
		
	@Autowired
	private DepartmentRepo repo;

	public Department saveDepartment(Department department) {
		
		return repo.saveAndFlush(department);
	}

	public Department findDepartmentById(Long departmentId) {
		
		return repo.findById(departmentId).get();
	}

	public List<Department> getAllDepartments() {
		
		return repo.findAll();
	}
}