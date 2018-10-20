package com.piy.applications;

import com.piy.basic.Stack;

public class Postfix {
	Stack stack;

	public static void main(String[] args) {
		String expr = "1 2 3 4 5 * + 6 * * +";
		String[] array = expr.split(" ");
		Postfix postfix = new Postfix(array.length);
		System.out.println(postfix.evaluate(array));
		
	}
	
	public Postfix(int size) {
		stack = new Stack(size);
	}
	
	public Integer evaluate(String[] array) {
		int opt1 = 0;
		int opt2 = 0;
		int value = 0;
		for(int i=0;i<array.length;i++) {
			switch(array[i]) {

			case "/":
				opt2 = stack.pop();
				opt1 = stack.pop();
				value = opt1/opt2;
				stack.push(value);
				break;
			case "*":
				opt2 = stack.pop();
				opt1 = stack.pop();
				value = opt1*opt2;
				stack.push(value);
				break;
			case "+":
				opt2 = stack.pop();
				opt1 = stack.pop();
				value = opt1+opt2;
				stack.push(value);
				break;
			case "-":
				opt2 = stack.pop();
				opt1 = stack.pop();
				value = opt1-opt2;
				stack.push(value);
				break;
			default :
				stack.push(Integer.parseInt(array[i]));
			}
		}
		if(stack.getTop()==1){
			return stack.pop();
		}
		else {
			return null;
		}
	}

	public Stack getStack() {
		return stack;
	}

	public void setStack(Stack stack) {
		this.stack = stack;
	}

	
	
}
