package gs;

public class MathPowerOfTen {

	public static void main(String[] args) {
		System.out.println(isPowerOfTen(0.0001));
	}

	public static boolean isPowerOfTen(double d) {
		if(d > 0 && d < 1) {
			while(d < 1) {
				d*=10;
			}
		}
		else {
			while(d > 1) {
				d /= 10;
			}
		}
		return d==1;
	}

}
