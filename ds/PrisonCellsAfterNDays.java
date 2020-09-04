package ds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays {

	public static void main(String[] args) {
		int[] banned = {1,0,0,1,0,0,1,0 };
		prisonAfterNDays(banned, 1000000000);
	}

	public static int[] prisonAfterNDays(int[] cells, int N) {
		System.out.println(Arrays.toString(cells));
		
		Set<String> set = new HashSet<>();
		
		int row = cells.length;
		if (N == 0)
			return cells;
		int check = N;
		boolean cycle = false;
		while (N > 0) {
			int previ = cells[0];
			for (int i = 0, j = 2; i < row - 2; i++, j++) {
				if (previ == cells[j]) {
					previ = cells[i + 1];
					cells[i + 1] = 1;
				}
				else {
					previ = cells[i + 1];
					cells[i + 1] = 0;
				}
			}
			if(check == N) {
				cells[0] = 0;
				cells[row - 1] = 0;
			}
			
			N--;
			
			if(!cycle) {
				if(!set.contains(Arrays.toString(cells)))
					set.add(Arrays.toString(cells));
				else {
					cycle = true;
					N = check%(check -N -1);
					check = --N;
				}
			}
			System.out.println(Arrays.toString(cells));
			
		}

		return cells;
	}

}
