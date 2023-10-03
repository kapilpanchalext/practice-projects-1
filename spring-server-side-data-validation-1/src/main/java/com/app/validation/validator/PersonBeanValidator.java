package com.app.validation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.validation.bean.PersonBean;

public class PersonBeanValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return PersonBean.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		PersonBean p = (PersonBean) target;

		if(p.getFirstName() == null) {
			ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
			errors.rejectValue("firstName", "");
			System.err.println("FIRSTNAME FIELD: " + p);
		}

		if (p.getLastName() != null && !p.getLastName().matches("[A-Za-z]+")) {
	            errors.rejectValue("lastName", "lastName.invalid", "Last Name is not valid");
	            System.err.println("LASTNAME FIELD: " + p.getLastName() + " :does not match!");
	    }
	}
}