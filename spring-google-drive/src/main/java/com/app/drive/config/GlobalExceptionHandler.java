package com.app.drive.config;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.app.drive.exception.CalendarAccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CalendarAccessDeniedException.class)
	    public RedirectView notFoundException(final CalendarAccessDeniedException e, RedirectAttributes attributes) throws IOException {
	        e.getMessage();
	        RedirectView redirectView = new RedirectView("/unauthorized",true);
			redirectView.addStaticAttribute("message",e.getMessage());
			attributes.addFlashAttribute("message", e.getMessage());
			    return redirectView;
	}
}