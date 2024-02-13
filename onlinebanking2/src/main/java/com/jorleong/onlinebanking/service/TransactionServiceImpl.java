package com.jorleong.onlinebanking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorleong.onlinebanking.domain.Transaction;
import com.jorleong.onlinebanking.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Transactional
	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

//	@Override
//	public boolean fromAccExists(long accountFromOrTo) {
//		return transactionRepository.exists(accountFromOrTo);
//	}


}
