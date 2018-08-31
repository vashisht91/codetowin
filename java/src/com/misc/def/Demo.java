package com.misc.def;

public class Demo implements TestInterface1{

	public static void main(String[] args) {
		TestInterface1 obj = new Demo();
		obj.print();
		TestInterface1.show();
		obj.print1();
	}

	/*@Override
	public void show2() {
		
	}*/
/*
	@Override
	public void show() {
		
	}*/

/*	@Override
	public void print() {
		TestInterface1.super.print();
	}*/

}
