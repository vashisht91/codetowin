package com.designpatterns.builder;

import java.util.concurrent.SynchronousQueue;

public class BuilderDemo {

	public static void main(String[] args) {
//		Computer computer = new Computer.ComputerBuilder("4GB","500GB").setBluetoothEnabled(true).setGraphicCardEnabled(true).build();
		Computer computer = new Computer.ComputerBuilder("4GB","500GB").build();
		
		System.out.println(computer.toString());
	}

}
