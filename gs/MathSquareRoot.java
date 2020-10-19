package gs;

public class MathSquareRoot {

	public static void main(String[] args) {
		System.out.println(squareRoot(257));
	}
	
	public static int squareRoot(int d) {
		int count =0, sub = 1;
		while(d>0) {
			d-=sub;
			sub+=2;
			count++;
		}
		if(d==0)
			return count;
		return -1;
	}

}
