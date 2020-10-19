package gs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MathAddTwoFractions {

	public static void main(String[] args) {
		String expression = "3/2+1/2";
		System.out.println(fractionAddition(expression));
	}

	 public static String fractionAddition(String expression) {
	        String[] frac = expression.split("[+-]");
	        List<Integer> deno = new ArrayList<>();
	        List<Integer> nume = new ArrayList<>();
	        for(String s : frac) {
	        	if(s.equals(""))
	        		continue;
	            String[] temp = s.split("/");
	            nume.add(Integer.parseInt(temp[0]));
	            deno.add(Integer.parseInt(temp[1]));
	        }
	        int lcm = LCM(deno);
	        Queue<String> queue = new LinkedList<>();
	        for(char c : expression.toCharArray()) {
	            if(c == '+' || c == '-')
	                queue.add(c+"");
	        }
	    
	        int sum = calc(deno, nume, lcm, queue);
	        
	        return sum+"/"+lcm;
	    }
	    
	    public static int LCM(List<Integer> deno) {
	        Collections.sort(deno);        
	        int lcm = deno.get(deno.size()-1);
	        boolean found = false;
	        while(!found) {
	            found=true;
	            for(int i : deno) {
	                if(lcm%i != 0) {
	                    found = false;
	                    break;
	                }
	            }
	            if(!found)
	                lcm++;
	        }
	        return lcm;
	        
	    }
	    
	    public static int calc(List<Integer> deno, List<Integer> nume, int lcm, Queue<String> queue) {
	        int sum = 0;
	        
	        for(int i=0 ; i<deno.size(); i++) {
	            int div = lcm/deno.get(i);
	            int val = div * nume.get(i);
	            String sign = queue.remove();
	            if(sign.equals("-"))
	                val = val * (-1);
	            
	            sum += val;
	        }
	        
	        return sum;
	    }
}
