package com.jorleong.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorleong.onlinebanking.domain.Customer;
import com.jorleong.onlinebanking.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public boolean existsById(long id) {
		return customerRepository.existsById(id);
	}

//	@Override
//	public boolean existsById(Customer customer) {
//		return customerRepository.existsById(customer.getCustomerId());
//	}
	
}
