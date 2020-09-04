package ds;

import java.util.*;

public class StringPartitionLabels {

	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(S));
	}

	public static List<Integer> partitionLabels(String S) {

		Map<Character, List<Integer>> map = new HashMap<>();
		int l = 0;

		for (char c : S.toCharArray()) {
			if (map.get(c) == null) {
				List<Integer> list = new ArrayList<>();
				list.add(l);
				map.put(c, list);
			} else {
				List<Integer> list = map.get(c);
				list.add(l);
				map.put(c, list);
			}
			l++;
		}

		List<Integer> res = new ArrayList<>();

		int currStart = 0;
		int currEnd = 0;

		for (int i = 0; i < S.length(); i++) {

			char c = S.charAt(i);
			List<Integer> check = map.get(c);
			currEnd = Math.max(currEnd, check.get(check.size() - 1));
			if (currEnd == i) {
				res.add(currEnd - currStart + 1);
				currStart = i + 1;
				currEnd = i + 1;
				continue;
			}
		}

		return res;

	}
}
