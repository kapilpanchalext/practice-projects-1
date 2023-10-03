package com.app.thymeleaf.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/api/v1")
public class HelloController {

	@GetMapping(path = "/hello")
	public ModelAndView getHelloController() {
		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("employees");
		return mav;
	}
}