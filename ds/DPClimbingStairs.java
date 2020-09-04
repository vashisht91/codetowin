package ds;

import java.util.*;

public class DPClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(5));
		System.out.println(climbStairs(6));
		System.out.println(climbStairs(7));
		System.out.println(climbStairs(8));
		System.out.println(climbStairs(9));
		System.out.println(climbStairs(10));
		
	}
	
	  public static int climbStairs(int n) {
	        if(n==1)
	            return 1;
	        if(n==2)
	            return 2;
	        
//	        Map<Integer, Set<String>> map = new HashMap<>(3);
	        Set<String> set1 = new HashSet<>();
	        set1.add("1");
//	        map.put(1, set1);
	        Set<String> set2 = new HashSet<>();
	        set2.add("2");
	        set2.add("11");
//	        map.put(2, set2);
	        
	        return helper(n, 2,set2, set1);
	        
	    }
	    
	    public static int helper(int n, int count, Set<String> set2,Set<String> set1) {
	        if(n == count)
	            return set2.size();
	        Set<String> newSet = new HashSet<>();
	        for(String s : set2) {
	            newSet.add(s+"1");
	        }
	        for(String s : set1) {
	            newSet.add(s+"11");
	            newSet.add(s+"2");
	        }
	        
//	        System.out.println(Arrays.asList(newSet));
	        
	        return helper(n, ++count, newSet, set2);
	             
	    }

}
