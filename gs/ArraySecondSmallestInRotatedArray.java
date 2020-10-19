package gs;

public class ArraySecondSmallestInRotatedArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0};
		System.out.println(findSecondMin(nums));
	}
	
	public static int findSecondMin(int[] nums) {
        if(nums == null)
            return Integer.MAX_VALUE;
        if(nums.length == 1)
            return Integer.MAX_VALUE;
        int min = search(nums, 0, nums.length-1);
        if(min == nums.length-1)
        	return nums[0];
        else
        	return nums[min+1];
    }
    
    public static int search(int[] nums, int low, int high) {
        if(low > high)
            return 0;
        int mid =  (low+high) /2;
        
        if(mid>0 && (nums[mid]< nums[mid-1]))
            return mid;
        
        if(nums[mid] < nums[high])
            return search(nums, 0, mid-1);
        else
            return search(nums, mid+1, high);
    }
}
