package com.netvn.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netvn.core.dao.UserRepository;
import com.netvn.core.entity.User;
import com.netvn.core.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String username, String password) {
		return userRepository.login(username, password);
	}

	@Override
	public User findUserByUserName(String username) {
		return userRepository.findUserByUserName(username);
	}
}
