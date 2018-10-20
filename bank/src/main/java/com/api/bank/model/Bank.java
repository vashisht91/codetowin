package com.api.bank.model;

public class Bank {
	private String bankName;
	private String corpId;
	
	public Bank(String bankName, String corpId) {
		super();
		this.bankName = bankName;
		this.corpId = corpId;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getCorpId() {
		return corpId;
	}
	
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	
	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", corpId=" + corpId + "]";
	}
	
	
	
}
