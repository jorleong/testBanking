package com.jorleong.onlinebanking.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId;
	private int passportId;
	private String customerfName;//be able to search for the account.java holderName
	private String customerlName;
	private String gender;
	private String mobile;
	private String email;
	
	@OneToMany//one customer many loans
	@JoinColumn(name="loanId")
	private List<Loan> loans = new ArrayList<Loan>();
	
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public int getPassportId() {
		return passportId;
	}
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
	public String getCustomerfName() {
		return customerfName;
	}
	public void setCustomerfName(String customerfName) {
		this.customerfName = customerfName;
	}
	public String getCustomerlName() {
		return customerlName;
	}
	public void setCustomerlName(String customerlName) {
		this.customerlName = customerlName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", passportId=" + passportId + ", customerfName=" + customerfName
				+ ", customerlName=" + customerlName + ", gender=" + gender + ", mobile=" + mobile + ", email=" + email
				+ ", loans=" + loans + "]";
	}
	
	
}
