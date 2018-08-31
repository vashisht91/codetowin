package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Anagrams {

static boolean isAnagram(String a, String b) {
        
        // Complete the function by writing your code here.
        String first = a.toLowerCase();
        String second = b.toLowerCase();
        
        if(first.length() != second.length()) {
            return false;
        }
        
        else {
            
            char[] ch1 = first.toCharArray();
            char[] ch2 = second.toCharArray();
            
            List<Character> l1 = new ArrayList<Character>();
            List<Character> l2 = new ArrayList<Character>();
            
	        for(int i=0;i<first.length();i++) {
	        	l1.add(ch1[i]);
	        	l2.add(ch2[i]);
	        }
            
            Collections.sort(l1);
            Collections.sort(l2);
            
            for(int i=0;i<l1.size();i++) {
                if(l1.get(i) != l2.get(i)) {
                    return false;
                }
            }
            return true;
        }
        
    }
	public static void main(String[] args) {
	    
	    Scanner scan = new Scanner(System.in);
	    String a = scan.next();
	    String b = scan.next();
	    scan.close();
	    boolean ret = isAnagram(a, b);
	    System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}
	
}
