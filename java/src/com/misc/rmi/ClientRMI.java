package com.misc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientRMI {

	public static void main(String[] args) {
		try {
			Search obj = (Search) Naming.lookup("rmi://localhost:1900/rmidemo");
			String response = obj.query("St1art");
			System.out.println("Response is : "+response);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}

}
