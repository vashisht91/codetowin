package com.misc.lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) throws IOException {
		List<Integer> l1 = Arrays.asList(3,2,6,4);
		System.out.println(l1);
		List<Integer> l2 = l1.stream().map(n -> n+n).collect(Collectors.toList());
		System.out.println(l2);
		List<Integer> l3 = l1.stream().filter(s -> s>3).collect(Collectors.toList());
		System.out.println(l3);
		List<Integer> l4 = l1.stream().sorted().collect(Collectors.toList());
		System.out.println(l4);
		
		
		l1.stream().map(x->x*x).forEach(y->System.out.println(y));
		System.out.println("reduce");
		int even = l1.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
		System.out.println(even);
		 
		 
//		 Runtime.getRuntime().exec("explorer.exe");
		 
	}

}
