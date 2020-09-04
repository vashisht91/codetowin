package ds;

public class ArrayPeakElement {

	public static void main(String[] args) {

		int[] in = {1,2,3,1};
		System.out.println(findPeakElement(in));
	}

	
    public static int findPeakElement(int[] nums) {
        int res = -1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]>nums[i+1] && nums[i] > nums[i-1]) {
                res= i;
                break;
            }
        }
        return res;
    }
}
