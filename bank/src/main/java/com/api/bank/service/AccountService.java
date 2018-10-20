package com.api.bank.service;

import java.util.List;

import com.api.bank.model.Account;
import com.api.bank.model.Bank;
import com.api.bank.model.Transaction;

public interface AccountService {

	public List<Account> getAccounts(String bankname);
	
	public List<Transaction> getTransactions(String accountnum); 
	
}
