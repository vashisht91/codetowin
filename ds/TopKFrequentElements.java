package ds;

import java.util.*;

public class TopKFrequentElements {

	
	
	public static void main(String[] args) {
		int[] arr = { 1,1,1,2,2,3,4,5 };
		System.out.println(Arrays.toString(topKFrequent(arr, 3)));
	}

	 public static int[] topKFrequent(int[] nums, int k) {
		    // build hash map : character and how often it appears
		    HashMap<Integer, Integer> count = new HashMap();
		    int[] res = new int[k];
		    for (int n: nums) {
		      count.put(n, count.getOrDefault(n, 0) + 1);
		    }

		    // init heap 'the less frequent element first'
		    PriorityQueue<Integer> heap =
		            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

		    // keep k top frequent elements in the heap
		    for (int n: count.keySet()) {
		      heap.add(n);
		      if (heap.size() > k)
		        heap.poll();
		    }

		    // build output list
		    List<Integer> top_k = new LinkedList();
		    while (!heap.isEmpty())
		    	res[--k] = heap.poll();
		    
		    return res;
		  }
	
	
	/*public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[k];
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer>[] bucket = new List[nums.length + 1];
		for (int n : map.keySet()) {
			int freq = map.get(n);
			if (bucket[freq] == null) {
				bucket[freq] = new LinkedList<>();
			}
			bucket[freq].add(n);
		}

		for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
			if (bucket[i] != null) {
				List<Integer> l = bucket[i];
				int s = l.size() - 1;
				while (s >= 0 && k > 0) {
					res[--k] = l.get(s--);
				}
			}
		}
		return res;
	}
*/
	/*
	 * public static int[] topKFrequent(int[] nums, int k) { Arrays.sort(nums);
	 * int[] res = new int[k]; Map<Integer, Integer> map = new HashMap<>(); int
	 * count = 1; int i = 1; int prev = nums[0]; map.put(nums[0], 1); while (i <
	 * nums.length) { if(nums[i] == prev) { count++; i++; }
	 * 
	 * else { map.put( nums[i-1], count); prev = nums[i]; count = 1; i++; } }
	 * 
	 * if(count == 1) { map.put( nums[i-1], count); }
	 * 
	 * Collection<Integer> set = map.values(); List<Integer> list = new
	 * ArrayList<>(set); Collections.sort(list); int listSize = list.size();
	 * 
	 * for(int l=listSize-1, j=0 ; l>list.size()-1-k ; l--) { res[j++] =
	 * map.get(list.get(l)); }
	 * 
	 * return res; }
	 */
}
