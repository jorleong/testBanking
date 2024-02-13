package com.jorleong.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorleong.onlinebanking.domain.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
}
