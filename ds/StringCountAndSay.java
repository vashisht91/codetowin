package ds;

import java.util.*;

public class StringCountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(20));
	}

	public static String countAndSay(int m) {

		int n = m-1;
        if(n==0)
            return "1";
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while(n!=0) {
            int[] value = new int[q.size()];
            int[] count = new int[q.size()];
            int size = q.size();
            for(int i=0; i<q.size();i++) {
                value[i] = Integer.MAX_VALUE;
                count[i] = Integer.MAX_VALUE;
            }
            
            int j = 0;
            int curr = Integer.MIN_VALUE;
            int prev = Integer.MIN_VALUE;
            int currCount =0;
            while(j<size) {
                curr = q.remove();
                if(curr==prev) {
                    currCount++;
                }
                else{
                    if(prev==Integer.MIN_VALUE) {
                        prev = curr;
                        currCount++;
                        j++;
                    }
                    else {
	                    value[j-1] = prev;
	                    count[j-1] = currCount;
	                    currCount = 1;
	                    prev = curr;
	                    j++;
                    }
                }
                if(q.isEmpty()) {
                	value[j-1] = prev;
                    count[j-1] = currCount;
                    break;
                }
            }
            
            
            for(int k=0 ; k<size; k++) {
                if(value[k] != Integer.MAX_VALUE) {
                    q.add(count[k]);
                    q.add(value[k]);
                }
            }
            n--;
        }
        
        String res = "";
        while(!q.isEmpty())
            res+=q.remove();
        
        return res;
    }
}
