package ds;

import java.util.Arrays;

public class SpiralMatrixII {

	public static void main(String[] args) {
		int[][] result = generateMatrix(4);
		for(int i=0; i<result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

	public static int[][] generateMatrix(int n) {

		int[][] result = new int[n][n];
		int last = n * n;
		int curr = 1;

		int i = 0;
		int j = 0;
		int dir = 0;
		while (curr <= last) {
			result[i][j] = curr++;
			if (dir % 4 == 0) {
				if (j + 1 == n || result[i][j+1] != 0) {
					i++;
					dir++;
				} else {
					j++;
					continue;
				}
			} else if (dir % 4 == 1 ) {
				if (i + 1 == n || result[i+1][j] != 0) {
					j--;
					dir++;
				} else {
					i++;
					continue;
				}
			} else if (dir % 4 == 2) {
				if (j - 1 == -1 || result[i][j-1] != 0) {
					i--;
					dir++;
				} else {
					j--;
					continue;
				}
			} else {
				if (i - 1 == -1 || result[i-1][j] != 0) {
					j++;
					dir++;
				} else {
					i--;
					continue;
				}
			}
		}
		return result;
	}

}
