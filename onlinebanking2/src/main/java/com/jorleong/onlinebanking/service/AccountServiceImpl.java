package com.jorleong.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.jorleong.onlinebanking.domain.Account;
import com.jorleong.onlinebanking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void save(Account acc) {
		accountRepository.save(acc);
		
	}

	@Override
	public void updateById(long accNo) {
		accountRepository.findById(accNo);
		
	}

	@Override
	public void deleteById(long accNo) {
		accountRepository.deleteById(accNo);
	}

	@Override
	public Account getById(long accNo) {
		Optional<Account> account = accountRepository.findById(accNo);
		return account.get();
	}

	@Override
	public List<Account> findAll() {
		List<Account> accountList = accountRepository.findAll();
		return accountList;
	}

	@Override
	@Transactional
	public void depositById(long accNo, double accBalance) {
		accountRepository.depositById(accNo, accBalance);
		
	}
	@Override
	@Transactional
	public void withdrawById(long accNo, double accBalance) {
		accountRepository.withdrawById(accNo, accBalance);
		
	}

	@Override
	public boolean existsById(long accNo) {
		return accountRepository.existsById(accNo);
	}

	@Override
	public List<Account> findByBalanceLessThan(double accBalance) {
		List<Account> accountList = accountRepository.findByAccBalanceLessThan(accBalance);
		return accountList;
	}
	@Override
	@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED)
	public double depositById2(long accNo, double accBalance) {
		Optional<Account> account =  accountRepository.findById(accNo);
		
		double balance = account.get().getAccBalance() + accBalance;
		account.get().setAccBalance(balance);
		accountRepository.save(account.get());
		System.out.println(account.get()+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return balance;
		
	}
}
