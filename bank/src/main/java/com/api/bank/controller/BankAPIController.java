package com.api.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.bank.model.Account;
import com.api.bank.model.Bank;
import com.api.bank.model.Transaction;
import com.api.bank.model.User;
import com.api.bank.service.AccountService;
import com.api.bank.service.BankService;
import com.api.bank.service.UserService;

@RestController(value="/api")
public class BankAPIController {
	@Autowired
	UserService userService;
	@Autowired
	AccountService accountService;
	@Autowired
	BankService bankService;
	
	@RequestMapping(value="/register/", method= RequestMethod.POST)
	public void registerUser(@RequestBody User user) {
		
	}
	
	@RequestMapping(value="/login/", method= RequestMethod.POST)
	public void loginUser(@RequestBody User user) {
		
		userService.login(user.getUserName(), user.getPassword());
	}
	
	@RequestMapping(value="/getbanklist/", method= RequestMethod.GET)
	public List<Bank> getBankList() {
		
		return bankService.getBankList();
	}
	
	@RequestMapping(value="/getbankdata/{bankname}/", method= RequestMethod.GET)
	public Bank getBankData(@PathVariable String bankname) {
		
		return bankService.getBank(bankname);
	}
	
	@RequestMapping(value="/logintobank/{bankname}/", method= RequestMethod.POST)
	public void loginBank(@RequestBody String username, @RequestBody String password, @RequestBody String corpId, @PathVariable String bankname) {
		
		bankService.login(username, password, corpId, bankname);
	}
	
	@RequestMapping(value="/api/getaccounts/{bankname}/", method= RequestMethod.GET)
	public List<Account> getAccounts(@PathVariable String bankname) {
		
		return accountService.getAccounts(bankname);
	}
	
	@RequestMapping(value="/api/gettransactiondata/{accountnum}/", method= RequestMethod.GET)
	public List<Transaction> getTransactionData(@PathVariable String accountnum) {
		
		return accountService.getTransactions(accountnum);
	}
	
}
