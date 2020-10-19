package gs;

public class ArrayTravellerFund {

	public static void main(String[] args) {
		int arr[] = {3, 5, 2, 6, 1};
		System.out.println(initialMoney(arr));
		
	}
	
	public static int initialMoney(int[] arr) {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int val : arr ) {
			sum += val;
			if(sum < min)
				min = sum;
		}
		
		return min>0?1:Math.abs(min)+1;
	}

}
