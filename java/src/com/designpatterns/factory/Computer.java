package com.designpatterns.factory;

public abstract class Computer {
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	public String toString() {
		return "Ram is "+getRAM()+", HDD is "+getHDD()+", CPU is "+getCPU();
	}
}
