package com.piy.applications;

import com.piy.basic.StackUsingLinkedList;

public class Postfix {
	StackUsingLinkedList stack;

	public static void main(String[] args) {
		Postfix postfix = new Postfix();
		String expr = "1 2 3 4 5 * + 6 * * +";
		String[] array = expr.split(" ");
		System.out.println(postfix.evaluate(array));
		
	}
	
	public Postfix() {
		stack = new StackUsingLinkedList();
	}
	
	public Integer evaluate(String[] array) {
		int opt1 = 0;
		int opt2 = 0;
		int value = 0;
		for(int i=0;i<array.length;i++) {
			switch(array[i]) {

			case "/":
				opt2 = stack.pop().getData();
				opt1 = stack.pop().getData();
				value = opt1/opt2;
				stack.push(value);
				break;
			case "*":
				opt2 = stack.pop().getData();
				opt1 = stack.pop().getData();
				value = opt1*opt2;
				stack.push(value);
				break;
			case "+":
				opt2 = stack.pop().getData();
				opt1 = stack.pop().getData();
				value = opt1+opt2;
				stack.push(value);
				break;
			case "-":
				opt2 = stack.pop().getData();
				opt1 = stack.pop().getData();
				value = opt1-opt2;
				stack.push(value);
				break;
			default :
				stack.push(Integer.parseInt(array[i]));
			}
		}
		if(stack.getSize()==1){
			return stack.pop().getData();
		}
		else {
			return null;
		}
	}

	public StackUsingLinkedList getStack() {
		return stack;
	}

	public void setStack(StackUsingLinkedList stack) {
		this.stack = stack;
	}

	
	
}
