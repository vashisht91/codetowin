package ds;

import java.util.*;
import java.util.regex.Pattern;

public class StringFirstUniqueCharacter {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("dddccdbba"));
	}
	
	public static int firstUniqChar(String s) {
	       if(s.length() == 0 || s==null)
	            return -1;
	        if(s.length() ==1)
	            return 0;
	      
	        char[] str = s.toCharArray();
	        int[] ch = new int[26];
	        for(int i=0 ; i<26; i++) {
	            ch[i]= -1;
	        }
	        
	        for(int i=0; i<str.length ; i++) {
	            if(ch[str[i]-'a'] == -1) {
	                ch[str[i]-'a'] = i;    
	            }
	            else {
	                ch[str[i]-'a'] = -2;
	            }
	            
	        }
	        
	        int small=Integer.MAX_VALUE;
	        for(int val : ch) {
	            if(val>-1 && val<small) {
	                small=val;
	            }
	        }
	        
	        return small==Integer.MAX_VALUE?-1:small;
	    }

	/*public static int firstUniqChar(String s) {
		if(s.length() == 0 || s==null)
            return -1;
        if(s.length() ==1)
            return 0;
        char[] ch = s.toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<ch.length ;i++ ) {
           map.put(ch[i], map.getOrDefault(ch[i],0)+1); 
        }
        
        for(int j=0; j<ch.length ;j++ ) {
           if(map.get(ch[j])==1)
               return j;
        }
        
        return -1;
    }*/
	
	
}
