package com.java.features.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.java.features.model.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<UserDetails> getUserDetails() {
		List<UserDetails> userDetailsList = new ArrayList<>();
		for(int i=0; i<100000; i++) {
			UserDetails userDetails = UserDetails.builder()
					.userId("userId" + i)
					.firstName("firstName" + i)
					.lastName("lastName" + i)
					.email("email" + i)
					.phone(i+1234567890L)
					.build();
			userDetailsList.add(userDetails);
		}
		return userDetailsList;
	}

}
