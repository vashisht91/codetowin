package ds;
import java.util.*;

public class RottingOranges {

	public static void main(String[] args) {
		int[][] interval = {{0,1}} ;
		for(int i=0; i<interval.length; i++) {
			System.out.println(Arrays.toString(interval[i]));
		}
		System.out.println(orangesRotting(interval));
	}

	public static int orangesRotting(int[][] grid) {
		if (grid == null || grid[0].length == 0)
			return -1;
		int r = grid.length;
		int c = grid[0].length;

		int res = 0;

		Set<int[]> fresh = new HashSet<>();
		Set<int[]> rotten = new HashSet<>();
		insertInSet(grid, fresh, 1);
		insertInSet(grid, rotten, 2);

		int freshSize = fresh.size();
		int rottenSize = rotten.size();

		if (freshSize == 0)
			return 0;

		while (freshSize != 0) {
			for (int[] point : rotten) {
				int row = point[0];
				int col = point[1];

				if (row + 1 < r) {
					if (grid[row + 1][col] == 1)
						grid[row + 1][col] = 2;
				}

				if (row - 1 > -1) {
					if (grid[row - 1][col] == 1)
						grid[row - 1][col] = 2;
				}

				if (col + 1 < c) {
					if (grid[row][col + 1] == 1)
						grid[row][col + 1] = 2;
				}

				if (col - 1 > -1) {
					if (grid[row][col - 1] == 1)
						grid[row][col - 1] = 2;
				}
			}
			fresh.clear();
			rotten.clear();
			insertInSet(grid, fresh, 1);
			insertInSet(grid, rotten, 2);
			int newFreshSize = fresh.size();
			int newRottenSize = rotten.size();
			if (freshSize == newFreshSize)
				return -1;
			freshSize = newFreshSize;
			rottenSize = newRottenSize;
			res++;
		}
		return res;

	}
	
	public static void insertInSet(int[][] grid, Set<int[]> set, int val) {
		int r = grid.length;
		int c = grid[0].length;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == val) {
					int[] arr = {i, j};
					set.add(arr);
				}
			}
		}
	}

}
