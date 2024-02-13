package com.jorleong.onlinebanking.ws;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="TransferRequest")
public class TransferRequest {
	
	private long toAcc;
	private long fromAcc;
	private double transferAmount;
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
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	@Override
	public String toString() {
		return "TransferRequest [toAcc=" + toAcc + ", fromAcc=" + fromAcc + ", transferAmount=" + transferAmount + "]";
	}
	
	
	
	

}
