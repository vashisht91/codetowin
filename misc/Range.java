package misc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Range {
	
	public static void main(String[] args) {
		Range r = new Range();
		int input1 = 3;
//		int[][] input2 = {{1,3}, {2,5}, {3,6}};
		
		int[][] input2 = {{1,3}, {2,5}, {6,9}};
		
		System.out.println(r.minPoints(input1, input2));
	}
	
	
	public int minPoints(int input1, int[][] input2) {
		
		Map<Integer, Integer> range = new ConcurrentHashMap<>();
		
		for(int i=0; i<input1; i++) {
			int in1 = input2[i][0];
			int in2 = input2[i][1];
			if(range.size()==0) {
				range.put(in1, in2);
				continue;
			}			
			
			boolean found = false;
			for(Map.Entry<Integer, Integer> entry : range.entrySet()) {
				int first = entry.getKey();
				int last = entry.getValue();
				
				if(in1 > first && in1 < last) {
					if(in2 > first && in2 < last) {
						found = true; 
						break;
					}
					
					if(in2 > last) {
						range.put(first, in2);
						found = true;
						break;
					}
				}
				
				if(in1 < first) {
					if(in2 > first && in2 < last) {
						range.remove(first);
						range.put(in1, last);
						found = true;
						break;
					}
					if(in2 > last) {
						range.remove(first);
						range.put(in1, in2);
						found = true;
						break;
					}
				}
				
			}
			
			if(!found) {
				range.put(in1, in2);
			}
			
		}
		
		return range.size();
	}

}
