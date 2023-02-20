package com.app02.rediscachemysql.api;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app02.rediscachemysql.model.Employee;
import com.app02.rediscachemysql.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeREST {

	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<Page<Employee>> getAllEmployees() {
        
    	try {
            Page<Employee> employees = employeeService.getAllEmployees(1, 10);
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
    	System.err.println("INSIDE GET EMPLOYEE BY ID METHOD");
        Employee employee = employeeService.findEmployeeById(id);
        
        if (employee != null){
        	System.err.println("INSIDE IF BLOCK");
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = employeeService.saveEmployee(employee);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(_employee.getId()).toUri();

            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateTutorial(@PathVariable("id") long id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = Optional.ofNullable(employeeService.findEmployeeById(id));

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            employee.setAge(employee.getAge());
            employee.setName(employee.getName());
            employee.setSalary(employee.getSalary());
            employee.setModifiedDate(LocalDateTime.now());
            return new ResponseEntity<>(employeeService.saveEmployee(_employee), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployees(@PathVariable("id") long id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
