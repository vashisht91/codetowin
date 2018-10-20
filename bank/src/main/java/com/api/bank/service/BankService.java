package com.api.bank.service;

import java.util.List;

import com.api.bank.model.Bank;

public interface BankService {
	
	public String login(String user, String password, String corpId, String bankname);
	
	public List<Bank> getBankList();
	
	public Bank getBank(String bankname);
	
}
