package ds;

import java.util.*;

public class StringRepeatedDNASequences {

	public static void main(String[] args) {
	
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
	
	  public static List<String> findRepeatedDnaSequences(String s) {
		  if(s.length()<10) {
	            return new ArrayList<>();
	        }
	        int start = 0;
	        int end = 10;
	        
	        Set<String> occurance = new HashSet<>();
	        Set<String> result = new HashSet<>();
	        
	        while(end<=s.length()) {
	            String sub = s.substring(start,end);
	            if(occurance.contains(sub)) {
	                result.add(sub);
	                
	            }
	            else{
	                occurance.add(sub);
	            }
	            start++;
                end++;
	        }
	        
	        return new ArrayList(result);
	    }

}
