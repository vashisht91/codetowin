package com.misc;

public class UserInput {
	
    public static class TextInput {
        String current="";
        
    	public void add(char c) {
    		current = current+c;
        }
        
        public String getValue(){
            return current;
        }
    }

    public static class NumericInput extends TextInput{
    	public void add(char c) {
    		if(c<='9') {
    			current = current+c;
    		}
    	}
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
//    	TextInput input = new TextInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}