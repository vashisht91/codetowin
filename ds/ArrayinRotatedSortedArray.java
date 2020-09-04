package ds;

public class ArrayinRotatedSortedArray {

	public static void main(String[] args) {

		int[] nums = {3,1};
		int target = 1;
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0 )
           return -1;
        
       int start = 0;
       int end = nums.length -1;
       
       while(start<=end){
           int mid = (start+end)/2;
           if(nums[mid] == target)
               return mid;
           
           if(nums[start] <= nums[mid]) {
               if(target >= nums[start] && target<=nums[mid]) {
                   end = mid-1;
               }
               else
                   start = mid+1;
           }
           
           else if (nums[mid] <= nums[end]) {
               if(target >= nums[mid] && target<=nums[end]) {
                  
                    start = mid+1;
               }
               else
                  end = mid-1;
           }
           else
        	   return -1;
       }
       return -1;
   }
	/*public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0 )
            return -1;
        
        int pivot = findPivot(nums);
        System.out.println("pivot : "+pivot);
        if(pivot == -1)
            return -1;
        int start = 0;
        int end = nums.length-1;
        
            if(target == nums[pivot])
                return pivot;
            else if(target < nums[start] || start==pivot )
            	start = pivot;
            else
            	end = pivot-1;
            
            while(start<=end){
                int mid = (start+end)/2;
                if(nums[mid] == target)
                    return mid;
                else if(nums[mid] < target)
                    start = mid+1;
                else
                    end = mid-1;
            }
            return -1;
    }
    */
    public static int findPivot(int[] nums) {
        if(nums[0] <= nums[nums.length-1])
            return 0;
        
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end) {
            int mid = (start+end)/2;
            
            if(nums[mid]>nums[mid+1]) 
                return mid+1;
            else if(nums[start] <= nums[mid]){
                start = mid+1;
            }
            else {
                end = mid-1;
            }  
        }
        return -1;
    }
}
