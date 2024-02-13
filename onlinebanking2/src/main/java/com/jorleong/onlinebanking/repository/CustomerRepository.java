package com.jorleong.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorleong.onlinebanking.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
