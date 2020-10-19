package misc;

public class ReplaceDigit {

	public static void main(String[] args) {
		fooBar();
	}
	
	public static void fooBar() {
		for(int i = 1; i<101; i++) {
			StringBuilder sb = new StringBuilder();
			if(i%3==0)
				sb.append("foo");
			if(i%5==0)
				sb.append("bar");
			String temp = ""+i;
			for(int j=0; j<temp.length() ; j++) {
				int digit = Integer.parseInt(temp.substring(j, j+1));
				if(digit==3)
					sb.append("foo");
				if(digit==5)
					sb.append("bar");
			}
			
			System.out.println(i+" = "+sb.toString());
		}
		
	}

}
