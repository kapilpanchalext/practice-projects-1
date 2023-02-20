package com.app02.rediscachemysql2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app02.rediscachemysql2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM rediscache1.employees WHERE id=?",
			nativeQuery = true)
	Employee findEmployeeById(Long id);
}