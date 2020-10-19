package misc;

public class NumToWord {

	public static void main(String[] args) {
		int input = 984576;
		System.out.println("Input : "+input+" \nOutput : "+convert(input));
	}

	public static String convert(int number) {
		if(number == 0)
			return "Zero";
		String num = ""+number;
		StringBuilder result = new StringBuilder();
		for(int count=num.length(); count>0; count--) {
			int curr = Integer.parseInt(num.substring(0,1));
			if(curr == 0) {
				num = num.substring(1,num.length());
				continue;
			}
			if(count==6) {
				result.append(getUnit(curr)+" Lakh");
				num = num.substring(1,num.length());
				continue;
			}
			if(count==5) {
				curr = Integer.parseInt(num.substring(0,2));
				result.append(getTens(curr)+ " Thousand");
				count--;
				num = num.substring(2,num.length());
				continue;
			}
			if(count==4) {
				result.append(getUnit(curr)+ " Thousand");
				num = num.substring(1,num.length());
				continue;
			}
			if(count==3) {
				result.append(getUnit(curr)+ " Hundred");
				num = num.substring(1,num.length());
				continue;
			}
			if(count==2) {
				curr = Integer.parseInt(num.substring(0,2));
				result.append(getTens(curr));
				count--;
				num = num.substring(2,num.length());
				continue;
			}
			if(count==1) {
				result.append(getUnit(curr));
				continue;
			}
		}
		return result.toString();
	}
	
	public static String getUnit(int unit) {
		switch(unit) {
			case 1: return " One";
			case 2: return " Two";
			case 3: return " Three";
			case 4: return " Four";
			case 5: return " Five";
			case 6: return " Six";
			case 7: return " Seven";
			case 8: return " Eight";
			case 9: return " Nine";
		}
		
		return "";
	}
	
	public static String getTens(int ten) {
		if(ten < 20 && ten >10)
			return getTeens(ten);
		
		
		String temp = ""+ten;
		int first = Integer.parseInt(temp.substring(0,1));
		int second = Integer.parseInt(temp.substring(1,2));
		StringBuilder tempResult = new StringBuilder();
		
		switch(first) {
			case 1: tempResult.append(" Ten");break;
			case 2: tempResult.append(" Twenty");break;
			case 3: tempResult.append(" Thirty");break;
			case 4: tempResult.append(" Forty");break;
			case 5: tempResult.append(" Fifty");break;
			case 6: tempResult.append(" Sixty");break;
			case 7: tempResult.append(" Seventy");break;
			case 8: tempResult.append(" Eighty");break;
			case 9: tempResult.append(" Ninety");break;
		}
		
		return tempResult.append(getUnit(second)).toString();
		
	}
	
	public static String getTeens(int teen) {
		switch(teen) {
			case 11: return " Eleven";
			case 12: return " Twelve";
			case 13: return " Thirteen";
			case 14: return " Fourteen";
			case 15: return " Fifteen";
			case 16: return " Sixteen";
			case 17: return " Seventeen";
			case 18: return " Eighteen";
			case 19: return " Nineteen";	
		}
		return "";
	}

}
