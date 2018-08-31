package com.misc;

import java.util.ArrayList;
import java.util.Random;

public class TwoSum {
    public static Integer[] findTwoSum(int[] list, int sum) {
    	int[][] indices = new int[list.length][2];
    	ArrayList<Integer[]> array = new ArrayList<>();
    	
    	int count=0;
    	for(int i=0; i<list.length-1;i++) {
    		for(int j=i+1;j<list.length;j++) {
	    		if(list[i]+list[j] == sum) {
//	    			indices[count][0]=i;
//	    			indices[count][1]=j;
//	    			indices[count]= new int[] {i,j};
	    			array.add( new Integer[] {i,j});
	    			count++;
	    		}
    		}
    	}
    	if(count==0) {
    		return null;
    	}
    	else {
    		int rand = (int) (Math.random() * count);
    		return array.get(rand);
    	}
    }

    public static void main(String[] args) {
        Integer[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}