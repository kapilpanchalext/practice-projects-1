package com.app05.departmentserviceredis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app05.departmentserviceredis.model.DepartmentDetails;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentDetails, Long> {
	
}