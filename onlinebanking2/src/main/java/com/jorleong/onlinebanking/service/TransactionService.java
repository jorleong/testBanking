package com.jorleong.onlinebanking.service;

import java.util.List;

import com.jorleong.onlinebanking.domain.Transaction;

public interface TransactionService {
	public void save(Transaction transaction);
	public List<Transaction> findAll();
//	public boolean exists(long fromAcc);
//	public boolean 
}
