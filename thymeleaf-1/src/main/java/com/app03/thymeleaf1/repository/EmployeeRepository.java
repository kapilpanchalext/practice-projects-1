package com.app03.thymeleaf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app03.thymeleaf1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}