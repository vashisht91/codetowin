package ds;

import java.util.*;


public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	 public static List<String> generateParenthesis(int n) {
	        List<String> result = new ArrayList<>();

	        generator(result, "", 0, 0 , n );
	        
	        return result;
	        
	    }
	    
	    
	    public static void generator(List<String> list, String str, int open, int close, int max) {
	        if(str.length()==2*max ) {
	        		list.add(str);
	            return ;
	        }
	        
	        if(open < max) {
	            generator(list, str+"(", open+1, close, max);
	        }
	        if(close < open) {
	            generator(list, str+")", open, close+1, max);
	        }
	        return;
	    }
	
}
