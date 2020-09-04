package ds;
import java.util.*;

public class NumberofDiceRollsWithTargetSum {

	public static Set<String> set;
	public static void main(String[] args) {
		set = new HashSet<>();
		int d=30;
		int f=30 ;
		int target = 500;
		System.out.println(numRollsToTarget(d,f,target));
	}

	public static int numRollsToTarget(int d, int f, int target) {
		int[] dice = new int[d * f];
		int[] rev = new int[d * f];
		int pos = 0;
		int re = rev.length-1;
		for (int i = 1; i <= f; i++) {
			for (int j = 0; j < d; j++) {
				dice[pos++] = i;
				rev[re--] = i;
			}
		}

		int res = 0;
		
		for(int k=0; k<dice.length; k++) {
			res += recur(dice, k, d, target, "");

		}
		for(int k=0; k<dice.length; k++) {
			res += recur(rev, k, d, target, "");
		}
		

		return res;

	}
	


	public static int recur(int[] arr, int start, int count, int target, String s) {
		if(start== arr.length)
			return 0;
		
		if (count == 1 && arr[start] == target) {
			if(!set.contains(s+arr[start])) {
				set.add(s+arr[start]);
				return 1;
			}
			return 0;
		}

		if (count == 1 )
			return recur(arr, start + 1, count, target, s);

		return recur(arr, start + 1, count - 1, target - arr[start], s+arr[start]);
	}

}
