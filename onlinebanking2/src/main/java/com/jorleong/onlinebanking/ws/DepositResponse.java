package com.jorleong.onlinebanking.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="DepositResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositResponse {
	
	@XmlElement(name="accBalance")
	private double accBalance;
	
	@XmlElement(name="accno")
	private long accno;
	
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	@Override
	public String toString() {
		return "DepositResponse [accBalance=" + accBalance + ", accno=" + accno + "]";
	}
	
	
	

}
