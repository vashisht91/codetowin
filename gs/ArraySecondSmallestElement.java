package gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class ArraySecondSmallestElement {
	static int small = Integer.MAX_VALUE;
	static int secondSmall = Integer.MAX_VALUE;
	
	public static void main(String[] args) {

		int[] nums = {9,12,3,4,6,7,345,3,5,242,6,45,6,5};
		search(nums);
		System.out.println("Smallest : "+small+", Second Smallest : "+secondSmall);
	}
	
	public static void search(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < small) {
				secondSmall = small;
				small = arr[i];
			}
			else if(arr[i] < secondSmall & arr[i] != small) {
				secondSmall = arr[i];
			}
		}
	}
}
