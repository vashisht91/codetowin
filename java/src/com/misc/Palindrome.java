package com.misc;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        char[] ch = new char[word.length()];
        ch = word.toCharArray();
        for(int i=0,j=word.length()-1;i<j;i++,j--) {
            if(ch[i] != ch[j]) {
                return false;
            }
        }
        return true;
        
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
        isPalindrome("Deleveled");
    }
}