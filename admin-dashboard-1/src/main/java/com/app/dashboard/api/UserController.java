package com.app.dashboard.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.service.UserService;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserService service;
    
	@GetMapping(path = "/get-users")
	ResponseEntity<String> getUsers(){
		List<UserBean> users = service.getUsers();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Successful Retrieving: " + users.size() + " users.");		
	}
	
	@GetMapping(path = "/get-users-by-id")
	ResponseEntity<UserBean> getUsersById(@RequestParam(name = "userId") String userId){
		List<UserBean> users = service.getUsers();
		
		UserBean user = new UserBean();
		
		for(UserBean element : users) {
			if(element.getId().equalsIgnoreCase(userId)) {
				user = element;
			}
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(user);		
	}
	
	@GetMapping(path = "/get-products")
	ResponseEntity<String> getProducts(){
		List<ProductBean> products = service.getProducts();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Successful Retrieving: " + products.size() + " products.");		
	}
	
	@GetMapping(path = "/get-products-stats")
	ResponseEntity<List<DataProductStatBean>> getProductStats(){
		List<DataProductStatBean> productStats = service.getProductStats();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(productStats);		
	}
}
