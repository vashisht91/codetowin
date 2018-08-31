package com.hackerrank;

import java.util.Scanner;

public class StringCompare {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int sub = scan.nextInt();
		String min = "";
		String max = "";
		String temp = "";
		for(int i=0;i<=input.length()-sub;i++) {
			if(i==0) {
				min = input.substring(i, i+sub);
				max = input.substring(i, i+sub);
			}
			else {
				temp = input.substring(i, i+sub);
				if(temp.compareTo(max) > 0) {
					max = temp;
				}
				if(temp.compareTo(min) < 0) {
					min = temp;
				}
			}		
		}
		System.out.println(min);
		System.out.println(max);
	}
}
