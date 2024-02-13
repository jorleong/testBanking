package com.jorleong.onlinebanking.service;

import java.util.List;

import com.jorleong.onlinebanking.domain.Account;

public interface AccountService {
	public void save(Account acc);
	public void updateById(long accNo);
	public void deleteById(long accNo);
	public Account getById(long accNo);
	public List<Account> findAll();
	public void depositById(long id, double accBalance);
	public void withdrawById(long accNo, double accBalance);
	public boolean existsById(long accNo);
	public List<Account> findByBalanceLessThan(double accBalance);
	double depositById2(long accNo, double accBalance);
}
