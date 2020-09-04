package ds;

public class DPHouseRobber {

	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
	}	

	
	public static int rob(int[] nums) {
       int l = nums.length;
       int prevRob = 0;
       int prevNotRob = 0;
       
       for(int i=0 ; i<l ; i++) {
    	   int currRob = prevNotRob + nums[i];
    	   int currNotRob = Math.max(prevNotRob, prevRob);
    	   
    	   prevRob = currRob;
    	   prevNotRob = currNotRob;
       }
       return Math.max(prevRob, prevNotRob);
    }
}
