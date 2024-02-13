package com.jorleong.onlinebanking.ws;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="DepositRequest")
public class DepositRequest {
	private long accountId;
	private double amount;
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "DepositRequest [accountId=" + accountId + ", amount=" + amount + "]";
	}
	
	

}
