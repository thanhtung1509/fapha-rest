package com.netvn.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.netvn.core.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.username=?1 and u.password=?2")
	User login(String username, String password);
	
	@Query("select u from User u where u.username=?1")
	User findUserByUserName(String username);
}
