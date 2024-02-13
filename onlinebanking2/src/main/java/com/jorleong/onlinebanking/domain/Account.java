package com.jorleong.onlinebanking.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accNo;
	private String accType;
	
	private String accHolderName;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date openDate;
	private double accBalance;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bCode")
	private Branch branch;
	
	//maybe change to {CascadeType.ALL})
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="transaction_account",joinColumns= {@JoinColumn(name="accNo")},inverseJoinColumns= {@JoinColumn(name="id")})
	private Set<Transaction> transactions = new HashSet<Transaction>();

	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	public Account() {
		super();
	}

	public Account(long accNo, String accType, String accHolderName, Date openDate, double accBalance, Branch branch,
			Set<Transaction> transactions, User user) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.accHolderName = accHolderName;
		this.openDate = openDate;
		this.accBalance = accBalance;
		this.branch = branch;
		this.transactions = transactions;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", accHolderName=" + accHolderName + ", openDate="
				+ openDate + ", accBalance=" + accBalance + ", branch=" + branch + ", transactions=" + transactions
				+ ", user=" + user + "]";
	}
	
	

	
	
}
