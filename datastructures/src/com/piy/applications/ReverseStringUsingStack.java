package com.piy.applications;

public class ReverseStringUsingStack {

	char[] array;
	int maxSize;
	int top;
	
	public static void main(String[] args) {
		String input = "this is a reversed string";
		char[] array = input.toCharArray();
		ReverseStringUsingStack reverseString = new ReverseStringUsingStack(array.length);
		for(int i=0;i<array.length;i++) {
			reverseString.push(array[i]);
		}
		
		System.out.println(reverseString.getArray());
		for(int i=0,j=array.length-1;i<j;i++,j--) {
			char temp = reverseString.getArray()[j];
			reverseString.getArray()[j] = reverseString.getArray()[i];
			reverseString.getArray()[i] = temp;
		}
		System.out.println(reverseString.getArray());
		
	}

	public ReverseStringUsingStack() {}

	public ReverseStringUsingStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		array = new char[maxSize];
		top = -1;
	}

	public char[] getArray() {
		return array;
	}

	public void setArray(char[] array) {
		this.array = array;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
	public void push(char data) {
		if(isFull()){
			System.out.println("Stack is full");
			return;
		}
		else {
			array[++top] = data;
		}
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return '\u0000';
		}
		else {
			return array[top--];
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return '\u0000';
		}
		else {
			return array[top];
		}
	}
	
	public boolean isFull() {
		if(top==maxSize-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
