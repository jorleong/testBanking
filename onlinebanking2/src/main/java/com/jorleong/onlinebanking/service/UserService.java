package com.jorleong.onlinebanking.service;

import com.jorleong.onlinebanking.domain.User;

public interface UserService {
	public void save(User user);
	
	public User findByUsername(String username);
}
