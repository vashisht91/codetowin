package gs;

import java.util.HashMap;
import java.util.Map;

public class StringLongestSubstringWithoutRepeatingChar {

	public static void main(String[] args) {
		String s = "abba";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(5/4);
	}

	/* public static int lengthOfLongestSubstring(String s) {
	        if(s==null || s.length()==0)
	            return 0;
	        if(s.length()==1)
	            return 1;
	        
	        Map<Character, Integer> map = new HashMap<>();
	        int curr=0,start=-1,end=-1,length=s.length();
	        char[] c = s.toCharArray();
	        int result = 0;
	        while(curr < length) {
	            if(!map.containsKey(c[curr])) {
	                map.put(c[curr], curr);
	                if(map.size()==1)
	                    start = curr;
	                end = curr;
	            }
	           else{
		            	int tempStart = start;
		            	int temp = map.get(c[curr]);
		                start = map.get(c[curr]) + 1;
		                while(tempStart<=temp) {
		                	map.remove(c[tempStart++]);
		                }
		                
		                map.put(c[curr], curr);
		                end = curr;
		            }
	            if(end-start+1 > result)
	                result = end-start+1;
	            curr++;
	        }   
	        
	        return result;
	    }*/
	 
	 
	   public static int lengthOfLongestSubstring(String s) {
	        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	                j = Math.max(j,map.get(s.charAt(i))+1);
	            }
	            map.put(s.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
	    }
	 
}
