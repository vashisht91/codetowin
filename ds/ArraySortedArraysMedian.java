package ds;

public class ArraySortedArraysMedian {

	public static void main(String[] args) {
		
		int[] num1 = {0,0};
		int[] num2 = {0,0};
		
		System.out.println(findMedianSortedArrays(num1, num2));

	}

	
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        if(nums1.length > nums2.length) {
	            return findMedianSortedArrays(nums2, nums1);
	        }
	        

	        int start = 0;
	        int end = nums1.length;
	        
	        while(start<=end){
	                    
	            int xPartition = (start+end)/2;
	            int yPartition = (nums1.length+nums2.length+1)/2 - xPartition;
	        
	            
	            int maxLeftX = (xPartition==0 ? Integer.MIN_VALUE : nums1[xPartition-1]);
	            int minRightX = (xPartition == nums1.length ? Integer.MAX_VALUE : nums1[xPartition]);
	            
	            int maxLeftY = (yPartition==0 ? Integer.MIN_VALUE : nums2[yPartition-1]);
	            int minRightY = (yPartition == nums2.length ? Integer.MAX_VALUE : nums2[yPartition]);
	                             
	            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
	                if( (nums1.length + nums2.length) %2 == 0) {
	                     return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)))/2;
	                }
	                else
	                    return (double)Math.max(maxLeftX, maxLeftY);               
	            }           
	            else if(maxLeftX > minRightY){
	                end = xPartition-1;
	            }
	            else if(minRightX < maxLeftY) {
	                start = xPartition +1;
	            }
	                             
	        }
	        return 0;
	        
	    }
}
