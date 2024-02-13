package com.jorleong.onlinebanking.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="TransferResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferResponse {

	@XmlElement(name="fromAcc")
	private long fromAcc;
	
	@XmlElement(name="fromAccountTransferAmount")
	private double fromAccTransferAmount;
	
	@XmlElement(name="toAcc")
	private long toAcc;
	
	@XmlElement(name="ToTransferAmount")
	private double toAccTransferAmount;
	
	public long getToAcc() {
		return toAcc;
	}

	public void setToAcc(long toAcc) {
		this.toAcc = toAcc;
	}

	public long getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(long fromAcc) {
		this.fromAcc = fromAcc;
	}

	public double getToAccTransferAmount() {
		return toAccTransferAmount;
	}

	public void setToAccTransferAmount(double toAccTransferAmount) {
		this.toAccTransferAmount = toAccTransferAmount;
	}

	public double getFromAccTransferAmount() {
		return fromAccTransferAmount;
	}

	public void setFromAccTransferAmount(double fromAccTransferAmount) {
		this.fromAccTransferAmount = fromAccTransferAmount;
	}

	@Override
	public String toString() {
		return "TransferResponse [toAcc=" + toAcc + ", fromAcc=" + fromAcc + ", toAccTransferAmount="
				+ toAccTransferAmount + ", fromAccTransferAmount=" + fromAccTransferAmount + "]";
	}

	
	
	
}
