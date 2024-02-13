package com.jorleong.onlinebanking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorleong.onlinebanking.domain.Account;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Account acc) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void save(Account acc) {
//		String sql = "insert into account (accNo,accType,accHolderName,bCode,openDate,accBalance) values("
//				+ acc.getAccNo() + ", '" + acc.getAccType() + "', '" + acc.getAccHolderName()
//				+ "', " + acc.getbCode()+"', '" + acc.getOpenDate()+"', '" + acc.getAccBalance() + ")";
//		jdbcTemplate.update(sql);
//		
//		System.out.println("Employee saved........");
//		
//	}
}
