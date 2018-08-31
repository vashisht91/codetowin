package com.misc.def;

public interface TestInterface2 {
	public void show2();
	
	public default void print() {
		System.out.println("TestInterface2");
	}
}
