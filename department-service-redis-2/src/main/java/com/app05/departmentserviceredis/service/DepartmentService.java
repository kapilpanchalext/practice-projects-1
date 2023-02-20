package com.app05.departmentserviceredis.service;

import com.app05.departmentserviceredis.model.DepartmentDetails;

public interface DepartmentService {

	DepartmentDetails saveDepartment(DepartmentDetails departmentDetails);

	DepartmentDetails getDepartmentById(Long departmentId);
}