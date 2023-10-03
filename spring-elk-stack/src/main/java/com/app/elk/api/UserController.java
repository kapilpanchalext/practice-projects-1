package com.app.elk.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.elk.bean.UserBean;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping(path = "/getUser/{id}")
	public UserBean getUserById(@PathVariable(name = "id") long id) {
		List<UserBean> users = getUsers();
		
		UserBean user = users.stream().filter(u -> u.getId() == id).findAny().orElse(null);
		
		if(user != null) {
			logger.info("User found: {}", user);
			return user;
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("User not found with UserId: {}", user);
				return new UserBean();
			}
		}		
	}

	private List<UserBean> getUsers() {
		return Stream
				.of(new UserBean(1, "John"), new UserBean(2, "Shyam"), new UserBean(3, "Rony"), new UserBean(4, "mak"))
				.collect(Collectors.toList());
	}

}