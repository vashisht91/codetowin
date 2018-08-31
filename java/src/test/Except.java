package test;

public class Except {

	public static void main(String[] args) {

		System.out.println("Inside main method!");
		int iReturned = new Except().testMethod();
		System.out.println("Returned value of i = " + iReturned);

	}

	public int testMethod() {
		int i = 0;
		try {
			System.out.println("Inside try block of testMethod!");
			i = 100;
			return i;
		} catch (Exception e) {
			System.out.println("Inside catch block of testMethod!");
			i = 200;
			return i;
		} finally {
			System.out.println("Inside finally block of testMethod!");
			i = 300;
			// return i;
		}
	}
}