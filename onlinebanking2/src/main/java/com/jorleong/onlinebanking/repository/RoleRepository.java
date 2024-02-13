package com.jorleong.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorleong.onlinebanking.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
