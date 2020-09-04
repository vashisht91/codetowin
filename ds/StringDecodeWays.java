package ds;

import java.util.Arrays;

public class StringDecodeWays {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		System.out.println(numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
//		System.out.println(numDecodingsDP("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
		System.out.println(numDecodingsNEW("00"));
		System.out.println("Total Time : "+(System.currentTimeMillis() - start));
	}

	
	 public static int numDecodingsNEW(String s) {
	        if(s ==  null || s.length() == 0)
	            return 0;
	        int n = s.length();
	        
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = s.charAt(0) != '0' ? 1 : 0;
	        
	        for(int i=2 ; i<=n ; i++) {
	             System.out.println(Arrays.toString(dp));
	            if(s.charAt(i-1) > '0') {
	                dp[i] += dp[i-1];
	            }
	            
	            if((s.charAt(i-2) < '2' && s.charAt(i-2) > '0') || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7') ) {
	                dp[i] += dp[i-2];
	            }
	        }
	       
	        
	        return dp[n];
	    }
	
	
	   public static int numDecodingsDP(String s) {
	        if(s == null || s.length() == 0) {
	            return 0;
	        }
	        int n = s.length();
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = s.charAt(0) != '0' ? 1 : 0;
	        for(int i = 2; i <= n; i++) {
	            int first = Integer.valueOf(s.substring(i-1, i));
	            int second = Integer.valueOf(s.substring(i-2, i));
	            if(first >= 1 && first <= 9) {
	               dp[i] += dp[i-1];  
	            }
	            if(second >= 10 && second <= 26) {
	                dp[i] += dp[i-2];
	            }
	        }
	        return dp[n];
	    }
	
	 public static int numDecodings(String s) {
		 int n = s.length();
	        if(n==1 && s.charAt(0) == '0')
	            return 0;
	        if(n == 0 || n == 1)
	            return 1;
	        
	        
	        int count = 0;
	        
	        if(s.charAt(n-1) > '0') {
	            count += numDecodings(s.substring(0, n-1));
	        }
	        
	        if((s.charAt(n-2) <'2' && s.charAt(n-2) >'0') || (s.charAt(n-2) == '2' && s.charAt(n-1) <'7')) {
	            count+= numDecodings(s.substring(0, n-2));
	        }
	           
	        return count;
	    }
}
