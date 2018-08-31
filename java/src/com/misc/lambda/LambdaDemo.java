package com.misc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		LambdaInterface1 l1 = () -> System.out.println("Hi There");
		l1.print();
		
		LambdaInterface2 l2 = (x) -> x*x;
		System.out.println(l2.num(10));
		
		LambdaInterface3 l3 = (x, y) -> x+y;
		System.out.println(l3.sum(10, 30));
		List<String> list1 = new ArrayList<>();
		list1.add("adam");
		list1.add("paul");
		list1.add("james");
		
		list1.forEach(name -> System.out.println(name));
		list1.forEach(name -> {if(name.equalsIgnoreCase("adam")) System.out.println(name);
								else System.out.println("Not adam");});
	}

}
