package com.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public static void main(String[] args) {
//		 int[] B = {5, 4, 4, 5, 0, 12};
		int[] B = {1, 4, 7, 3, 3, 5};
//		 Arrays.sort(B);
//		 for(int i = 0 ; i < B.length ; i++) {
//		 System.out.println(B[i]);
//		 }
		 System.out.println(Solution.solution(B));
		 
	}
 
	public static int solution(int[] A) {
		 Map<Integer, Map<Integer, Integer>> map = new ConcurrentHashMap<>();
		int maxLength = 0;
		for(int i = 0 ; i < A.length ; i++) {
		int element = A[i];
		 for(int j = i+1 ; j <= A.length-1 ; j++) {
			 int comp = A[j];
			 int diff = Math.abs(element - comp);
			 if(map.get(element)!= null) {
				 if(map.get(element).keySet().contains(comp)) {
					 int temp = map.get(element).get(comp);
					 if(diff<temp) {
						 map.get(element).put(comp, temp);
						 if(j-i>maxLength) {
							 maxLength = j-i;
						 }
					 }
				 }
				 else {
					 for(Integer key : map.get(element).keySet()) {
						 if(key>diff) {
							 map.get(element).put(comp, diff);
							 map.remove(key);
						 }
					 }
					 
				 }
				 
			 }
			 else {
				 Map<Integer, Integer> newMap = new HashMap<>();
				 newMap.put(comp, diff);
				 map.put(element, newMap);
				 if(j-i>maxLength) {
					 maxLength = j-i;
				 }
			 }
		 } 
	 }
	 return maxLength;

 }
 
 public static int solution1(int[] A) {
    int first = 0;
    int second = 0;
    int maxSize = 0;
	int internalSize = 0;
    for(int i=1; i<A.length ; i++) {

    	if(i<2) {
    		first = A[i-1];
    		second = A[i];
    		maxSize = 2;
    		internalSize = 2;
    	}
    	else {
    		if(A[i]==first || A[i]==second) {
    			internalSize+=1;
    			if(internalSize> maxSize) {
    				maxSize = internalSize;
    			}
    		}
    		else {
    			internalSize = 2;
    			first = second;
    			second = A[i];
    		}
    	}
    	
    }
	 return maxSize;
 }
}
