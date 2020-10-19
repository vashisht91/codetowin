package misc;

import java.util.ArrayList;
import java.util.List;

public class ConcatString {

	public static void main(String[] args) {

		List<String> str = new ArrayList<String>();
		str.add("       MESSAGE 1 THIS IS THE FIRST   ");
		str.add("       MESSAGE 1 THIS IS THE SECOND   ");
		str.add("       MESSAGE 1 THIS IS THE THIRD   ");
		str.add("       MESSAGE 1 THIS IS THE FOURTH   ");
		str.add("       MESSAGE 1 THIS IS THE FIFTH   ");
		str.add("       MESSAGE 1 THIS IS THE SIXTH   ");
		str.add("       MESSAGE 1 THIS IS THE SEVENTH   ");
		str.add("       MESSAGE 1 THIS IS THE EIGHTH   ");

		StringBuilder result = new StringBuilder();
		int count = 0;
		for(String s:str){	
			String rtrim = s.replaceAll("\\s+$", "");
			for(char c : rtrim.toCharArray()) {
				if(count == 80) {
					result.append("\n");
					result.append(c);
					count=1;
				}
				else {
					result.append(c);
					count++;
				}
			}
		}
		
		System.out.println(result.toString());
	}

}
