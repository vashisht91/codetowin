package ds;

import java.util.*;

public class ArrayNextGreaterElementI {

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,2,4};
		int[] nums2 = {6,5,4,3,2,1,7};
		
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
	}

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1== null || nums2 == null || nums1.length == 0 || nums2.length==0 )
            return new int[0];
        Stack<Integer> s = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums2) {
            while(!s.isEmpty() &&  s.peek()< num ) 
                map.put(s.pop(),num);
            s.push(num);    
        }
        
        
        int[] res = new int[nums1.length];
        for(int j=0; j<nums1.length;j++) {
            res[j] = map.getOrDefault(nums1[j],-1);
        }
        return res;
    }
}
