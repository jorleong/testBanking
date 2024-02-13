package com.jorleong.onlinebanking.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Branch {
	
	@Id
	private int bCode;
	
	private String name;
	private String location;
	
	@OneToMany
	@JoinColumn(name="accNo")
	private List<Account> accounts = new ArrayList<Account>();
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public int getbCode() {
		return bCode;
	}
	public void setbCode(int bCode) {
		this.bCode = bCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Branch [bCode=" + bCode + ", name=" + name + ", location=" + location + ", accounts=" + accounts + "]";
	}
	
	
}
