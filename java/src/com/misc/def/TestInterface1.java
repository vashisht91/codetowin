package com.misc.def;

public interface TestInterface1 {
	public static void show() {
		System.out.println("TestInterface1 Static method");
	}
	
	public default void print() {
		System.out.println("TestInterface1");
	}
	
	public default void print1() {
		System.out.println("TestInterface11");
	}
}
