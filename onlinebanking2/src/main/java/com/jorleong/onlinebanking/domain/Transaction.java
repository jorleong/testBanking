package com.jorleong.onlinebanking.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	private long id;
	
//	@ManyToOne
//	@JoinColumn(referencedColumnName="accNo",name="fromAcc")
	private long fromAcc;
//	@ManyToOne
//	@JoinColumn(referencedColumnName="accNo",name="toAcc")
	private long toAcc;
	private Date txDate;
	private String comments;
	private double accTx;
	
	@ManyToMany(mappedBy="transactions")
//	@JoinColumn(name="accNo")
	private Set<Account> account=new HashSet<Account>();
	
	public double getAccTx() {
		return accTx;
	}

	public long getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(long fromAcc) {
		this.fromAcc = fromAcc;
	}

	public long getToAcc() {
		return toAcc;
	}

	public void setToAcc(long toAcc) {
		this.toAcc = toAcc;
	}

	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	public void setAccTx(double accTx) {
		this.accTx = accTx;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", txDate=" + txDate
				+ ", comments=" + comments + ", accTx=" + accTx + "]";
	}
	
	
}
