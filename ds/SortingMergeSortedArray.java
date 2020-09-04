package ds;

import java.util.Arrays;

public class SortingMergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {0};
		int[] nums2 = {1};
		
		merge(nums1,0, nums2, 1);
		System.out.println(Arrays.toString(nums1));
	}

	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        int l = nums1.length, i = l-1, j = m-1 , k = n-1;
	        
	        for( ; i>=0 && j>=0 && k>=0 ; i--) {
	            if(nums1[j] >= nums2[k]) 
	                nums1[i] = nums1[j--];
	            else
	                nums1[i] = nums2[k--];
	        }
	        
	        while(j>-1) {
	            nums1[i--]=nums1[j--];
	        }
	        while(k>-1) {
	            nums1[i--]=nums2[k--];
	        }
    }
	
}
