package ds;

import java.util.*;

public class SubarrayswithKDifferentIntegers {

	public static void main(String[] args) {
		int[] banned = new int[4];
//		banned = { 2, 1, 2, 1, 2 };
//		System.out.println(Arrays.toString(banned));
//		System.out.println(subarraysWithKDistinct(banned, 2));
		System.out.println(banned[3]);
	}

	public static int subarraysWithKDistinct(int[] A, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], i);
			if (map.size() > K) {
				// new num in window
				// remove the small key	
				while (start <= i && start != map.get(A[start])) {
					start++;
				}
				int smallKey = A[start];
				map.remove(smallKey);
				start++;
				end = start;
			}
			while (end <= i && end != map.get(A[end])) {
				end++;
			}
			if (map.size() == K) {
				count += (end - start + 1);
			}
		}
		return count;
	}

	/*
	 * public static int subarraysWithKDistinct(int[] A, int K) { List<String> set =
	 * new ArrayList<>();
	 * 
	 * int start = 0; int end = 0; int diff = 0;
	 * 
	 * List<Integer> nums = new ArrayList<>(); while (true) { if (diff == K) {
	 * String s = ""; for (int i : nums) { s += i; } set.add(s); if (end ==
	 * A.length) { if(start >= A.length-K-1) break; else { end = start+1; start =
	 * end; diff = 0; nums = new ArrayList<>(); } } }
	 * 
	 * if (!nums.contains(A[end])) { nums.add(A[end++]); diff++; } else {
	 * nums.add(A[end++]); }
	 * 
	 * if (diff > K) { end = start+1; start = end; diff = 0; nums = new
	 * ArrayList<>(); } }
	 * 
	 * System.out.println(set.toString()); return set.size(); }
	 */
}
