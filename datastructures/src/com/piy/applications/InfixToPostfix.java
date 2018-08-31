package com.piy.applications;

import java.util.ArrayList;

import com.piy.basic.GenericStack;

public class InfixToPostfix {
	private GenericStack<Character> stack;
	
	public static void main(String[] args) {
//		String expr = "A + B * C + D";
		String expr = "(A +B) *C";
	    InfixToPostfix infixToPostfix = new InfixToPostfix();
	    Character[] characters = infixToPostfix.stringToChar(expr);
//	    System.out.println(infixToPostfix.convert(characters));
	    System.out.println(infixToPostfix.convertWithParanthesis(characters));
	}
	
	public InfixToPostfix() {
		stack = new GenericStack<Character>();
	}
	
	public InfixToPostfix(int arraySize) {
		stack = new GenericStack<Character>(arraySize);
	}

	public String convert(Character[] characters) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<characters.length;i++) {
			switch(characters[i]) {
			case '\u0000' : break;
			case '/':
				stack.push(characters[i]);
				break;
			case '*':
				stack.push(characters[i]);
				break;
			case '+':
				if(i!=characters.length-1 && this.getStack().isEmpty()) {
					stack.push(characters[i]);
				}
				else {
					if(stack.peek()=='*' | stack.peek()=='/' | stack.peek()=='+') {
						while(!stack.isEmpty()) {
							builder.append(stack.pop());
						}
						stack.push(characters[i]);
					}
					else {
						stack.push(characters[i]);
					}
				}
				break;
			case '-':
				if(i==characters.length-1 && this.getStack().isEmpty()) {
					stack.push(characters[i]);
				}
				else {
					while(!stack.isEmpty()) {
						builder.append(stack.pop());
					}
					stack.push(characters[i]);
				}
				break;
			default :
				builder.append(characters[i]);
			}
		}
		while(!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}

	public String convertWithParanthesis(Character[] characters) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<characters.length;i++) {
			switch(characters[i]) {
			case '\u0000' : break;
			case '(':
				stack.push(characters[i]);
				break;
			case '[':
				stack.push(characters[i]);
				break;
			case '{':
				stack.push(characters[i]);
				break;
			case ')':
				do{
					builder.append(stack.pop());
				} while(stack.pop()!='(');
				break;
			case ']':
				do{
					builder.append(stack.pop());
				} while(stack.pop()!='[');
				break;
			case '}':
				do{
					builder.append(stack.pop());
				} while(stack.pop()!='{');
				break;
			case '/':
				stack.push(characters[i]);
				break;
			case '*':
				stack.push(characters[i]);
				break;
			case '+':
				if(i!=characters.length-1 && this.getStack().isEmpty()) {
					stack.push(characters[i]);
				}
				else {
					if(stack.peek()=='*' | stack.peek()=='/' | stack.peek()=='+') {
						while(!stack.isEmpty()) {
							builder.append(stack.pop());
						}
						stack.push(characters[i]);
					}
					else {
						stack.push(characters[i]);
					}
				}
				break;
			case '-':
				if(i==characters.length-1 && this.getStack().isEmpty()) {
					stack.push(characters[i]);
				}
				else {
					while(!stack.isEmpty()) {
						builder.append(stack.pop());
					}
					stack.push(characters[i]);
				}
				break;
			default :
				builder.append(characters[i]);
			}
		}
		while(!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}
	
	public Character[] stringToChar(String expr) {
		Character[] characterArray = new Character[expr.length()];
		int count=0;
		
		for(int i=0;i<expr.length();i++) {
			if(expr.charAt(i)!=' ') {
				characterArray[count] = (Character)expr.charAt(i);
				count++;
			}
		}
		Character[] newCharacterArray = new Character[count];
		for(int j=0;j<count;j++) {
			newCharacterArray[j] = characterArray[j];
		}
		return newCharacterArray;
	}
	
	public GenericStack<Character> getStack() {
		return stack;
	}

	public void setStack(GenericStack<Character> stack) {
		this.stack = stack;
	}
	
	
}
