package com.jorleong.onlinebanking.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.format.annotation.DateTimeFormat;

import com.jorleong.onlinebanking.domain.Branch;

@XmlType(name="AccountResponse2")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountResponse2 {
	
	@XmlElement(name="accno")
	private long accno;
	
	@XmlElement(name="accType")
	private String accType;
	
	@XmlElement(name="accholdername")
	private String accholdername;
	
	@XmlElement(name="accBalance")
	private double accBalance;
	
	@XmlElement(name="date")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date openDate;
	
	@XmlElement(name="branch")
	private Branch branch;

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAccholdername() {
		return accholdername;
	}

	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "AccountResponse [accno=" + accno + ", accType=" + accType + ", accholdername=" + accholdername
				+ ", accBalance=" + accBalance + "]";
	}


	
	
	
	

}
