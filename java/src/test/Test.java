package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test implements Cloneable {
//	 final static int j=1;
	{
		System.out.println("init");
	}
	
	 public Test() {
//		 j = 1;
		 this("");
		 System.out.println("Test()");
	 }
	 
	 public Test(String s) {
		 System.out.println("Test(String)");
	 }
	 
	public static void main(String args[]) {
		long l = 200000;
		int i = (int)l;
//		System.out.println(i);
		
		int a=1, b=1;
		method(a, b);
		
		Test t = new Test();
		new Test();
//		System.out.println(t.j);
		
		Set<String> set = new HashSet<>();
		set.add("adf");
		set.add("asf");
		set.add("fdsvsd");
		List<String> list = new ArrayList<>(set);
		System.out.println(list.toString());
		System.out.println((int)Math.floor(2.5));
		
	}
	
	static public void method(long i, long j) {
		System.out.println("long");
	}
	
	public static void method(Integer i, Integer j) {
		System.out.println("Integer");
	}
	
	public static void method(int... a) {
		System.out.println("int");
	}
	
	/*public strictfp synchronized static final void main(String[] args) {
		int[] ar = {3,1,4,5,2};
		int[][] arr = {{1,2,3},{1,3},{35,3,5,2,5}};
		int[][] arr1 = {{1,2,3},{1,3},{35,3,5,2,5}};
		int[][][] arr2 = {{{1,2,3},{2},{3}},{{12,45},{1},{3}},{{35}}};
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.println(arr[i][j]);
			}
		}
		Arrays.sort(ar);
		System.out.println("Index: "+Arrays.binarySearch(ar, 2));
		System.out.println(Arrays.deepEquals(arr, arr1));
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.deepToString(arr2));
		Object a  = new Object();
		
	}*/
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
