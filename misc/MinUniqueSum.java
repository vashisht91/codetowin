package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinUniqueSum {

	public static void main(String[] args) {
//		int[] arr = {3,2,1,2,3};
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(getMinUniqueSum(list));
	}
	
	public static int getMinUniqueSum(List<Integer> arr) {
		int sum = 0;
		Set<Integer> set = new HashSet<>();
		for(int i=0 ; i<arr.size() ; i++) {
			int val = arr.get(i);
			if(!set.contains(val)) {
				set.add(val);
				sum += val;
			}
			else {
				arr.remove(i);
				arr.add(i,++val) ;
				i--;
			}
		}
		return sum;
		
	}

}
