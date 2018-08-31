package test;

public class Base {
	  private final void fun() {
	     System.out.println("Base fun");     
	  }
	  public static void main(String[] args) {
	      Base obj = new Derived();
	      obj.fun();
	  }  
	}
	   
	class Derived extends Base {
	  private void fun() {
	     System.out.println("Derived fun");  
	  }

	}