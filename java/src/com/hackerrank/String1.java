package com.hackerrank;

import java.util.Scanner;

public class String1 {
    public static void main(String[] args) {

	 Scanner sc=new Scanner(System.in);
//     String A="hello";
//     String B="world";
	 String A=sc.next();
	 String B=sc.next();
     /* Enter your code here. Print output to STDOUT. */
     int Alen = A.length();
     int Blen = B.length();
     int sum = Alen + Blen;
     int compare = A.compareTo(B);
     
     System.out.println(sum);
     if(compare >0)
    	 System.out.println("Yes");
     else
    	 System.out.println("No");
     
     System.out.print(A.substring(0, 1).toUpperCase()+A.substring(1)+ " ");
     System.out.print(B.substring(0, 1).toUpperCase()+B.substring(1));
    }
}
