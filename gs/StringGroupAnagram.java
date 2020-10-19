package gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringGroupAnagram {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
		
	}
	
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String curr : strs) {
        	char[] ch = curr.toCharArray();
        	int[] arr = new int[26];
        	for(char c : ch) {
        		arr[c-'a']++;
        	}
        	StringBuilder sb = new StringBuilder();
        	for(int i : arr) {
        		sb.append(i+"#");
        	}
        	
	        String keyStr = sb.toString();
	        
	        if(map.containsKey(keyStr)) {
	        	map.get(keyStr).add(curr);
	        }
	        else {
	        	List<String> list = new ArrayList<>();
	        	list.add(curr);
	        	map.put(keyStr, list);
	        }
        }
        
        return new ArrayList<>(map.values());
        
	}
	
	
/*	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        for(String curr : strs) {
            int listSize = result.size();
            if(listSize == 0) {
                List<String> currList = new ArrayList<>();
                currList.add(curr);
                result.add(currList);
                continue;
            }
            
            boolean found = true;
            for(List<String> list : result) {
            	found = true;
                String first = list.get(0);
                int[] arr = new int[26];
                
                for(char c : curr.toCharArray()) {
                    arr[c-'a']++;
                }
                for(char c : first.toCharArray()) {
                    arr[c-'a']--;
                }
                for(int i : arr) {
                    if(i!=0) {
                    	found = false;
                        break;
                    }
                }
                if(found) {                
                	list.add(curr);
                	break;
                }
            }
             if(!found) {
                    List<String> currList = new ArrayList<>();
                    currList.add(curr);
                    result.add(currList);
             }
          
        }   
        return result;   
    }
*/
}
