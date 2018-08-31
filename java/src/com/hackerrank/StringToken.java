package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToken {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
		String s = "hi there how you. it's";
        // Write your code here.
//        String pattern = "[[A-Za-z1-9\\s]+]."; //|[[^A-Za-z1-9]+].";
        String pattern = "[A-Za-z1-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        int count=0;
        List<String> list = new ArrayList<>();
        while(m.find()) {
            list.add(s.substring(m.start(), m.end()));
            count++;
        }
        System.out.println(count);
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i));
        }
        scan.close();
        
        // Java Regex 1
        	
  /*      String s = "0";
        String p1 = "[0-1]|[5-6]";
//        String p1 = "(([0-1]?[0-9]?[0-9]\\.)|([2]?[0-4]?[0-9]\\.)|([2]?[5]?[0-5]\\.)){3}(([0-1]?[0-9]?[0-9])|([2]?[0-4]?[0-9]\\.)|([2]?[5]?[0-5]\\.)){1}";
//        String p1 = "[0-1][0-9][0-9]||[2][0-5][0-5][.]{1,3}";
        Pattern p = Pattern.compile(p1);
        Matcher m = p.matcher(s);
        System.out.println(m.matches());*/
        
	}
}
