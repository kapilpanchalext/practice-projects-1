package com.app05.userserviceredis.service;

import com.app05.userserviceredis.model.UserDetails;

public interface UserService {

	UserDetails saveUser(UserDetails userDetails);

	UserDetails getUserDetailsById(Long userId);
}