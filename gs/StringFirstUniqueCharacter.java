package gs;

public class StringFirstUniqueCharacter {

	public static void main(String[] args) {

		String s = "leetcode";
		System.out.println(firstUniqChar(s));
	}
	
	 public static int firstUniqChar(String s) {
	        int[] arr = new int[26];
	        
	        for(char c : s.toCharArray()) {
	            arr[c-'a']++;
	        }
	        
	        int i=0;
	        for(char c : s.toCharArray()){
	            if(arr[c-'a'] == 1)
	                return i;
	            else
	                i++;
	        }
	        return -1;
	    }
}
