package com.designpatterns.abstractfactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2GB", "500GB", "2.00GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("32GB", "2TB", "3.00GHz"));
		
		System.out.println(pc);
		System.out.println(pc.getClass());
		System.out.println(server);
		System.out.println(server.getClass());
	}

}
