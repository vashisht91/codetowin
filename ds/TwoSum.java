package ds;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr= {5,25,75};
		System.out.println(Arrays.toString(twoSum(arr, 100)));
	}
	
	
	public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length-1;
        
        while(i<j) {
            if((numbers[i]+numbers[j]) > target) {
                j = binarySearchRight(numbers, target-numbers[i], i, j);
                continue;
            }
            else if((numbers[i]+numbers[j]) < target) {
                i = binarySearchLeft(numbers, target-numbers[j], i, j);
                continue;
            }
            else {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
    
    
    public static int binarySearchRight(int[] num, int target,int start,int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            if(num[mid] > target)
                end = mid-1;
            else if(num[mid] <= target)
                start = mid+1;
        }
        return end;
    }
    
        public static int binarySearchLeft(int[] num,int target,int start,int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            if(num[mid] >= target)
                end = mid-1;
            else if(num[mid] < target)
                start = mid+1;
        }
        return start;
    }
	
	
	/*
	 * public static int[] twoSum(int[] numbers, int target) { int[] res = new
	 * int[2]; int i = 0; int j = numbers.length-1;
	 * 
	 * while(i<j) { if((numbers[i]+numbers[j]) > target) { j--; continue; } else
	 * if((numbers[i]+numbers[j]) < target) { i++; continue; } else { res[0] = i+1;
	 * res[1] = j+1; } } return res; }
	 */
}
