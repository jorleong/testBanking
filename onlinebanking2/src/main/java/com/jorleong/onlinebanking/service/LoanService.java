package com.jorleong.onlinebanking.service;

import com.jorleong.onlinebanking.domain.Loan;

public interface LoanService {
	public void save(Loan loan);
	public boolean existsById(int loanId);
}
