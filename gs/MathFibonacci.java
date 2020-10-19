package gs;

public class MathFibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacciRecursive(12));
		System.out.println(fibonacciIterative(12));
	}
	
	public static int fibonacciRecursive(int n) {
		if(n==0)
			return 0;
		if(n==1 || n==2)
			return 1;
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2); 
	}

	public static int fibonacciIterative(int n) {
		if(n==0)
			return 0;
		if(n==1 || n==2)
			return 1;
		int i = 2;
		int curr = 0, prev=1, prev2=0;
		
		while(i<=n) {
				curr = prev + prev2;
				prev2 = prev;
				prev = curr;
				i++;
		}
		return curr;
	}
}
