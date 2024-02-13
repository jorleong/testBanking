package com.jorleong.onlinebanking.service;

import com.jorleong.onlinebanking.domain.Customer;

public interface CustomerService {
	public void save(Customer customer);
	public boolean existsById(long id);
//	public boolean existsById(Customer customer);
}
