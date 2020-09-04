package ds;
import java.util.*;

public class KClosestPointstoOrigin {

	public static void main(String[] args) {
		int[][] interval = {{1,3} ,{-2,2}} ;
		for(int i=0; i<interval.length; i++) {
			System.out.println(Arrays.toString(interval[i]));
		}
		System.out.println(kClosest(interval, 1));
	}

	public static int[][] kClosest(int[][] points, int K) {
		int[][] res = new int[K][2];
		Map<Integer, List<int[]>> map = new HashMap<>();

		int i = 0;
		for (int[] point : points) {
			int sum = (point[0] * point[0]) + (point[1] * point[1]);

			if (map.get(sum) != null) {
				List<int[]> list = map.get(sum);
				list.add(point);
				map.put(sum, list);
			} else {
				List<int[]> list = new ArrayList<>();
				list.add(point);
				map.put(sum, list);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		for (int j : map.keySet()) {
			pq.add(j);
		}

		int count = 0;
		while (K > 0 && !pq.isEmpty()) {
			List<int[]> l = map.get(pq.remove());
			int size = l.size();

			for (int n = 0; n < size && K > 0; n++, K--) {
				res[count++] = (int[]) l.get(n);
			}
		}

		if (K > 0)
			return null;
		return res;
	}
}
