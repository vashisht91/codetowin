package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCollection {

	public static void main(String[] args) {
		List<String> l1 = Arrays.asList("B", "C", "A");
		l1.sort(null);
		l1.forEach(System.out::println);
		
	}

}
