package ds;

import java.util.Arrays;

public class MergeIntervals {

	public static void main(String[] args) {
//		int[][] interval = {{1,3},{2,6},{8,10},{15,18}};
//		int[][] interval = {{1,4},{0,5}};
//		int[][] interval = {{4,5},{1,4},{0,1}};
		int[][] interval = {{0,2},{2,3},{4,4},{0,1},{5,7},{4,5},{0,0}};
		int[][] result = merge(interval);
		for(int i=0; i<result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
		
//		System.out.println(Arrays.toString(merge(interval)));
	}

	public static int[][] merge(int[][] intervals) {
		int m = intervals.length;
		int n = 2;
		int count = m;
		for (int i = 0; i < m; i++) {
			if(intervals[i][0] == Integer.MAX_VALUE && intervals[i][1] == Integer.MAX_VALUE)
				continue;
			for (int j = 0; j < m ; j++) {
				if(j==i)
					continue;
				if(intervals[j][0] == Integer.MAX_VALUE && intervals[j][1] == Integer.MAX_VALUE)
					continue;
				if (intervals[i][0] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
					if (intervals[i][1] > intervals[j][1]) {
						intervals[j][1] = intervals[i][1];
						intervals[i][0] = Integer.MAX_VALUE;
						intervals[i][1] = Integer.MAX_VALUE;
						count--;
						break;
					} else {
						intervals[i][0] = Integer.MAX_VALUE;
						intervals[i][1] = Integer.MAX_VALUE;
						count--;
						break;
					}
				}
				
				else if (intervals[i][1] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
					if (intervals[i][0] < intervals[j][0]) {
						intervals[i][1] = intervals[j][1];
						intervals[j][0] = Integer.MAX_VALUE;
						intervals[j][1] = Integer.MAX_VALUE;
						count--;
					} else {
						intervals[i][0] = Integer.MAX_VALUE;
						intervals[i][1] = Integer.MAX_VALUE;
						count--;
					}
				}
			}
		}

		int rows = count;
		int[][] result = new int[rows][2];

		for (int k = 0, l = 0; k < m && l < rows; k++) {
			if (intervals[k][0] == Integer.MAX_VALUE && intervals[k][1] == Integer.MAX_VALUE)
				continue;
			result[l][0] = intervals[k][0];
			result[l][1] = intervals[k][1];
			l++;
		}

		return result;
	}

}
