package ds;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class StringLongestCommonSubsequence {

	public static void main(String[] args) {
		String text1 = "ezupkr";
		String text2 = "ubmrapg";
		
		System.out.println(longestCommonSubsequence(text1, text2));
	}
	
	 public static int longestCommonSubsequence(String text1, String text2) {
	        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
	            return 0;
	        int l1 = text1.length();
	        int l2 = text2.length();
	        
	        int[][] seq = new int[l1][l2];
	       
	        int max = 0;
	        int i=0, j=0;
	        while(i<l1) {
	            char c1 = text1.charAt(i);
	            char c2 = text2.charAt(j);
	            
	            if(c1 == c2) {
	                if(i==0 || j==0)
	                    seq[i][j] = 1;
	                else {
	                		seq[i][j] = seq[i-1][j-1] + 1;
	                }
	                
	                if(seq[i][j] > max) {
	                    max = seq[i][j];
	                }
	            }
	            else {

	            	if(i==0 && j==0)
	            		seq[i][j] = 0;
	            	else if(i==0)
	            		seq[i][j] = seq[i][j-1];
	            	else if (j==0)
	            		seq[i][j] = seq[i-1][j];
	            	else
	            		seq[i][j] = Math.max(seq[i][j-1], seq[i-1][j] );
	            }
	            if(j < l2-1)
	                j++;
	            else {
	                j=0;
	                i++;
	            }
	        }
	        
	        return max;
	    }

}
