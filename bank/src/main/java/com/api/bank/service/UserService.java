package com.api.bank.service;

public interface UserService {

	public String registerUser(String username, String password);
	
	public String login(String username, String password);
	
}
