package com.app03.thymeleaf1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app03.thymeleaf1.model.Employee;

import com.app03.thymeleaf1.service.EmployeeService;
import java.util.List;
import java.util.Optional;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping({"/showEmployees", "/list", "/"})
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("list-employees");
		
		Optional<List<Employee>> employeeList = service.getAllEmployees();
		
		mav.addObject("employees", employeeList.get());
		return mav;
	}
	
	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee newEmployee = new Employee();
		
		mav.addObject("employee", newEmployee);
		return mav;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		
		boolean saveStatus = service.saveEmployee(employee);
		
		if(saveStatus == false) {			
			return "redirect:/addEmployeeForm";
		}		
		
		return "redirect:/list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee employee = service.findEmployeeById(employeeId);
		mav.addObject("employee", employee);
		return mav;
	}
}