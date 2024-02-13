package com.jorleong.onlinebanking.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loanId;
//	private int customerId;
	private double amount;
	private int bCode;
	private String loanType;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date loanDate;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getbCode() {
		return bCode;
	}
	public void setbCode(int bCode) {
		this.bCode = bCode;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", amount=" + amount + ", bCode=" + bCode + ", loanType=" + loanType
				+ ", loanDate=" + loanDate + ", customer=" + customer + "]";
	}
	
	
}
