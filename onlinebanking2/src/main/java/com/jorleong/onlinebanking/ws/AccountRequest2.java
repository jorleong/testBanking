package com.jorleong.onlinebanking.ws;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="AccountRequest2")
public class AccountRequest2 {
	private long accno;

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	
}
