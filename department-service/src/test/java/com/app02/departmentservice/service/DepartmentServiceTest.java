package com.app02.departmentservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app02.departmentservice.model.Department;
import com.app02.departmentservice.repo.DepartmentRepo;


@SpringBootTest
@RunWith(SpringRunner.class)
class DepartmentServiceTest {
	
	@InjectMocks
	private DepartmentService service;
	
	@Mock
	private DepartmentRepo repo;

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	@Transactional
	void testFindDepartmentById() {
		
		Department department = Department.builder()
				.departmentId(1L)
				.departmentName("Department 1")
				.departmentCode("DEP-1")
				.departmentAddress("Department Address")
				.build();
//		List<Department> departmentList = new ArrayList<>();
//		
//		Optional<Department> optDept = Optional.of(department);
//		
//		departmentList.add(department);
//		
//		List<Department> depList = service.getAllDepartments();
//		
//		Department dep = service.findDepartmentById(1L);
//		
//		System.err.println("DEP-LIST: " + depList.get(0));
//		
//		System.err.println("DEP: " + dep);
		System.err.println("TEST DEPARTMENT: " + department);
		
//		Mockito.when(repo.findById(1L).get()).thenReturn(department);
//		Mockito.mock(DepartmentService.class);
		Mockito.when(repo.findById(1L).get()).thenReturn(department);
		
//		assertThat(service.findDepartmentById(1L)).isEqualTo(department);		
	}
}