package com.jorleong.onlinebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jorleong.onlinebanking.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Modifying
	@Query(/*nativeQuery=true,name=*/"update Account a set a.accBalance = a.accBalance + :accBalance where a.accNo = :accNo")
	public void depositById(long accNo, double accBalance);
	
	@Modifying
	@Query("update Account a set a.accBalance = a.accBalance - :accBalance where a.accNo = :accNo")
	public void withdrawById(long accNo, double accBalance);
	
	public List<Account> findByAccBalanceLessThan(double accBalance);
}
