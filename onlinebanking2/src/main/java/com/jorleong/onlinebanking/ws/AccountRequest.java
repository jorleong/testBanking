package com.jorleong.onlinebanking.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

import org.springframework.format.annotation.DateTimeFormat;


@XmlType(name="AccountRequest")
public class AccountRequest {	
	private String accType;
	
	private String accHolderName;
	
	private double accBalance;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date openDate;
	
	private int bCode;
	
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public int getbCode() {
		return bCode;
	}

	public void setbCode(int bCode) {
		this.bCode = bCode;
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

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	
	
	
}
