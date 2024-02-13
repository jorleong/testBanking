package com.jorleong.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorleong.onlinebanking.domain.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
}
