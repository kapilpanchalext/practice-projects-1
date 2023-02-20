package com.app02.departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app02.departmentservice.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

}