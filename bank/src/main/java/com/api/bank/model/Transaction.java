package com.api.bank.model;

import java.util.Date;

public class Transaction {

	private Date timeStamp;
	private long amount;
	private String type;
	private Account account;
	

	public Transaction(Date timeStamp, long amount, String type, Account account) {
		super();
		this.timeStamp = timeStamp;
		this.amount = amount;
		this.type = type;
		this.account = account;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public long getAmount() {
		return amount;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [timeStamp=" + timeStamp + ", amount=" + amount + ", type=" + type + ", account=" + account.getId()
				+ "]";
	}
	

	
}
