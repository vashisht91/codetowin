package gs;

public class StringMinDistanceBetweenWords {

	public static void main(String[] args) {
		
		String s = "geeks for geeks contribute asdf fdsa practice sadf fasd geeks";
		String w1 = "geeks";
		String w2 = "practice";
		
		System.out.println(findMinDistance(s, w1, w2));
		
	}
	
	public static int findMinDistance(String s, String w1, String w2) {
		String[] words = s.split(" ");
		int i=0, prev = 0, minDistance = Integer.MAX_VALUE;
		
		for(; i< words.length; i++) {
			if(words[i].equals(w1) || words[i].equals(w2)) {
				prev = i;
				break;
			}
		}
		
		
		while(++i<words.length) {
			if((words[i].equals(w1) || words[i].equals(w2))) {
				if(!words[prev].equals(words[i]) && i-prev-1 < minDistance) {
					minDistance = i-prev-1;
					prev = i;
				}
				else 
					prev = i;
			}
		}
		
		return minDistance;
		
	}
}
