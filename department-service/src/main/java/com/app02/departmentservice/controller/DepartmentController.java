package com.app02.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app02.departmentservice.model.Department;
import com.app02.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
		
	@PostMapping(path = "/")
	public Department saveDepartment(@RequestBody Department department) {		
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping(path = "/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.findDepartmentById(departmentId);
	}
}
