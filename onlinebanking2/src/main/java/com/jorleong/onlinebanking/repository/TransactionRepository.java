package com.jorleong.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorleong.onlinebanking.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
//	@Query("select count(t) from Transaction t where t.fromAcc = :fromAcc")
//	public boolean fromAccountExists(long fromAcc);
//	
//	@Query("select count(t) from Transaction t where t.toAcc = :toAcc")
//	public boolean toAccountExists(long toAcc);
}
