package com.app02.rediscachemysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.app02.rediscachemysql.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Page<Employee> findAll(Pageable pageable);
}
