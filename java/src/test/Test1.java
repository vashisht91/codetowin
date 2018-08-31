package test;

import java.util.concurrent.SynchronousQueue;

public class Test1{
	public Test1(int a) {
		
	}
	
	public Test1() {}
	public static void check() {}
	public void check(int a) {}
	
	private void print() {
		System.out.println("Outer");
	}
	
	public class Inner extends Test1{
		private void print() {
			System.out.println("Inner");
		}
	}

	
/*	public static void main (String[] args) {
		Test1 t = new Test1();
		Inner i = t.new Inner();
		i.print();
		Test1 t1 = new Test1();
		t1.print();
	}*/
}

class Child extends Test1 {
	public Child() {
	}
	private void print() {}
	public static void main (String[] args) {
		Test1 t = new Test1();
//		Inner i = t.new Inner();
//		i.print();
		Test1 t1 = new Child();
//		t1.print();
	}

}
