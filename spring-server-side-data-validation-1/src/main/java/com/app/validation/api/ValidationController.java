package com.app.validation.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.validation.bean.PersonBean;
import com.app.validation.validator.PersonBeanValidator;

@RestController
@RequestMapping(path = "/api/v1")
public class ValidationController {

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){		
		
//		PersonBeanValidator validator = new PersonBeanValidator();
//	    // Create an instance of your PersonBean
//	    PersonBean bean = new PersonBean();
//	    
//	    // Create a new Errors object for validation
//	    Errors errors = new BeanPropertyBindingResult(bean, "personBean");
//		
//		validator.validate(validator, errors);
//		
//		System.err.println("BEAN: " + bean);		
//		return ResponseEntity.status(HttpStatus.OK).body("Successful");
		
		// Create an instance of your PersonBean
        PersonBean bean = new PersonBean();

        // Create a new Errors object for validation
        Errors errors = new BeanPropertyBindingResult(bean, "personBean");

        // Create an instance of your validator
        PersonBeanValidator validator = new PersonBeanValidator();

        // Perform manual validation, pass the PersonBean as the first argument
        validator.validate(bean, errors);

        // Check if there are validation errors
        if (errors.hasErrors()) {
            // Handle validation errors here
            return ResponseEntity.badRequest().body("Validation failed");
        }

        // Your logic for a successful request
        System.err.println("BEAN: " + bean);
        return ResponseEntity.status(HttpStatus.OK).body("Successful");
	}
	
	@GetMapping(path = "/hello-validation")
	public ResponseEntity<String> getHelloValidation(@RequestBody PersonBean personBean){
		
		System.err.println("PERSON BEAN: " + personBean);
		
        // Create a new Errors object for validation
        Errors errors = new BeanPropertyBindingResult(personBean, "personBean");

        // Create an instance of your validator
        PersonBeanValidator validator = new PersonBeanValidator();

        // Perform manual validation, pass the PersonBean as the first argument
        validator.validate(personBean, errors);

        // Check if there are validation errors
        if (errors.hasErrors()) {
            // Handle validation errors here
            return ResponseEntity.badRequest().body("Validation failed");
        }

        // Your logic for a successful request
        System.err.println("BEAN: " + personBean);
        return ResponseEntity.status(HttpStatus.OK).body("Successful");
	}
}
