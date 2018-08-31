package com.misc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class SearchServer {

	public static void main(String[] args) {
		try {
			Search obj = new SearchQuery();
			
			LocateRegistry.createRegistry(1900);
			
			Naming.rebind("rmi://localhost:1900/rmidemo", obj);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}

}
