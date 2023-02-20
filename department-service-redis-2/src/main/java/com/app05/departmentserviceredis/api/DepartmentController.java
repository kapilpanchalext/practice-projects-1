package com.app05.departmentserviceredis.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app05.departmentserviceredis.model.DepartmentDetails;
import com.app05.departmentserviceredis.service.DepartmentService;


@RestController
@RequestMapping(path = "/api/v1")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
		
	@PostMapping(path = "/")
	public DepartmentDetails saveDepartment(@RequestBody DepartmentDetails departmentDetails) {
		return service.saveDepartment(departmentDetails);
	}
	
	@GetMapping(path = "/get-department/{departmentId}")
	public DepartmentDetails getDepartmentById(@PathVariable("departmentId") Long departmentId) {
		return service.getDepartmentById(departmentId);
	}
}