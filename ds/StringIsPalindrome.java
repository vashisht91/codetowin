package ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class StringIsPalindrome {

	public static void main(String[] args) {

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		
		StringBuilder s = new StringBuilder("+123");
		System.out.println(Integer.parseInt(s.toString()));
	}
	


	public static boolean isPalindrome(String s) {
        if(s.length()==0 || s== null)
            return false;
        
        String s1 = s.toLowerCase();
        
        for(int i=0,j=s.length()-1 ; i<=j ; ) {
            if(!Pattern.matches("[a-z]/d",""+s1.charAt(i))) {
                i++;
                continue;
            }
            if(!Pattern.matches("[a-z]/d",""+s1.charAt(j))) {
                j--;
                continue;
            }
            if(s1.charAt(i)!=s1.charAt(j))
                return false;
            
            i++;
            j--;
        }
        return true;
    }
}
