package com.piy.applications;

import java.util.Scanner;

import com.piy.basic.GenericStack;

public class BalancedParenthesisUsingStack {
	private int length;
	private GenericStack<Character> stack;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		scan.close();
		BalancedParenthesisUsingStack stack = new BalancedParenthesisUsingStack(string.length());
		Character[] characterArray = stack.charToCharacter(string.toCharArray());
		System.out.println(stack.checkBalancedParenthesis(characterArray));
		
	}
	
	public BalancedParenthesisUsingStack(int length) {
		super();
		this.length = length;
		stack = new GenericStack<Character>(length);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public GenericStack<Character> getStack() {
		return stack;
	}

	public void setStack(GenericStack<Character> stack) {
		this.stack = stack;
	}

	public void push(Character ch) {
		stack.push(ch);
	}
	
	public Character pop() {
		return stack.pop();
	}
	
	public Character peek() {
		return stack.peek();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public boolean isFull() {
		return stack.isFull();
	}
	
	public boolean checkBalancedParenthesis(Character[] ch) {
		for(int i=0; i<ch.length;i++) {
			if(ch[i] == '{' || ch[i] == '[' || ch[i] == '(' ) {
				stack.push(ch[i]);
			}
			else {
				Character newChar = ch[i];
				switch(newChar) {
				case '}':
					if(stack.peek()=='{') {
						stack.pop();
					}
					else {
						return false;
					}
					break;
				case ']' : 
					if(stack.peek()=='[') {
						stack.pop();
					}
					else {
						return false;
					}
					break;
				case ')' : 
					if(stack.peek()=='(') {
						stack.pop();
					}
					else {
						return false;
					}
					break;
				default : 
					return false ;
				}
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Character[] charToCharacter(char[] ch) {
		Character[] character = new Character[ch.length];
		for(int i=0;i<ch.length;i++) {
			character[i] = ch[i];
		}
		return character;
	}
}

