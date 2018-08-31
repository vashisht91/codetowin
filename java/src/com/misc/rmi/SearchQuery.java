package com.misc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SearchQuery extends UnicastRemoteObject implements Search{
	
	public SearchQuery() throws RemoteException {
		super();
	}

	@Override
	public String query(String search) throws RemoteException {
		String result;
		if(search.equals("Start"))
			result = "Found";
		else 
			result = "Not Found";
		
		return result;
	}

}
