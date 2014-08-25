package com.netvn.core.service;

import com.netvn.core.entity.User;

public interface UserService {
	public User login(String username, String password);
	
	public User findUserByUserName(String username);
}
