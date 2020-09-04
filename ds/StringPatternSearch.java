package ds;

public class StringPatternSearch {

	public static void main(String[] args) {
		
		System.out.println(strStr("mississippi", "issip"));
		
	}
	
	
	 public static int strStr(String haystack, String needle) {
	      if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;
	      if(needle.length()==0)
	          return 0;
	        
	        int i=1;
	        int j=0;
	        int[] lps = new int[needle.length()];
	        char[] nee = needle.toCharArray();
	        
	        while(i < nee.length) {
	            if(nee[i] == nee[j]) {
	                lps[i] = j+1;
	                j++;
	                i++;
	            }
	            else{
	                if(j!=0) {
	                    j = lps[j-1];
	                }
	                else {
	                    lps[i] = 0;
	                    i++;
	                }
	            }
	        }          
	        
	        char[] hay = haystack.toCharArray();
	        
	        int k=0;
	        int l=0;
	        while(k < hay.length) {
	            if(hay[k]==nee[l]) {
	                k++;
	                l++;
	            }
	            else{
	                if(l!=0) {
	                    l= lps[l-1];
	                }
	                else{
	                    k++;
	                }
	            }
	            
	            if(l==nee.length) {
	                return k-l; 
	            }
	        }
	        
	        
	        return -1;
	        
	    }

}
