package com.designpatterns.abstractfactory;

public class ComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory computerAbstractFactory) {
		return computerAbstractFactory.createComputer();
	}
}
