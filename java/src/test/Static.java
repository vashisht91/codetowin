package test;

public class Static {
	
	static int i=1;
	int j = 0;
	
	public static void check() {
		Test test = new Test();
	}
	
	public static class Inner {
		public static void set() {
			Static.i = 5;
		}
		
	}
}
