package com.jorleong.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorleong.onlinebanking.domain.Loan;
import com.jorleong.onlinebanking.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	LoanRepository loanRepository;

	@Override
	public void save(Loan loan) {
		loanRepository.save(loan);
		
	}

	@Override
	public boolean existsById(int loanId) {
		return loanRepository.existsById(loanId);
	}
	
	
}
