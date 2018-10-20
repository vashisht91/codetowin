package com.api.bank.model;

public class Account {
	private long id;
	private String accountType;
	private Bank bank;
	
	public Account(long id, String accountType, Bank bank) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.bank = bank;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", bank=" + bank.getBankName() + "]";
	}
	
	
	

}
