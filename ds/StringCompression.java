package ds;

public class StringCompression {

	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','c'};
//		System.out.println(compress(chars));
		
		String a = "a";
		String b = "b";
		System.out.println("C".compareTo("a"));
		
	}
	
	 public static int compress(char[] chars) {
	        if(chars == null || chars.length == 0 )
	            return 0;
	        int l = chars.length;
	        int start = 0, curr = 0, count = 1, length = 0;
	        
	        while(curr <= l) {
	            if(curr == l) {
	                if(count != 1) {
	                    String s = ""+count;
	                    char[] newCh = s.toCharArray();
	                    chars[length] = chars[start]; 
	                    for(int i=0 ; i<newCh.length; i++) {
	                        chars[length+1+i] = newCh[i];                        
	                    }
	                    length+= newCh.length+1;
	                }
	                else 
	                    chars[length] = chars[start];
	                return length;
	            }
	            
	            if(start == curr) {
	                curr++;
	                continue;
	            }
	            
	            if(chars[start] == chars[curr]) {
	                count++;
	                curr++;
	                continue;
	            }
	            
	            else {
	                if(count == 1){
	                    chars[++length] = chars[start]; 
	                    start = curr;
	                    curr++;
	                    continue;
	                }
	                else {
	                    String s = ""+count;
	                    char[] newCh = s.toCharArray();
	                    chars[length] = chars[start]; 
	                    for(int i=0 ; i<newCh.length; i++) {
	                        chars[length+1+i] = newCh[i];                        
	                    }
	                    length+= newCh.length+1;
	                    start = curr;
	                    count = 1; 
	                    curr++;
	                    
	                    System.out.println(length+", "+count+", "+curr+", "+start);
	                }
	            }
	        }
	        return 0;
	    }

}
