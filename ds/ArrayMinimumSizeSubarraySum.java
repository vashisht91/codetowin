package ds;import java.time.chrono.MinguoChronology;

public class ArrayMinimumSizeSubarraySum {

	public static void main(String[] args) {

		int[] num = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, num));
	}

	
    public static int minSubArrayLen(int s, int[] nums) {
        
        int start = 0;
        int currentSum = 0;
        int res = Integer.MAX_VALUE;
        
        for(int end=0; end<nums.length ; end++) {
            currentSum += nums[end];
            
            while(currentSum >= s && start<=end) {
            	res = Math.min(res, end-start+1);
            	currentSum = currentSum - nums[start++];
            }
           
        }
        return res;
    }
}
