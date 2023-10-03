package com.app.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.redis.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM rediscache1.employees WHERE id=?",
			nativeQuery = true)
	Employee findEmployeeById(Long id);
}
