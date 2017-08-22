package com.piy;

public class Stack {
	
	private int top;
	private int maxSize;
	private int[] array;

	public static void main(String[] args) {
		Stack stack = new Stack(3);
		stack.push(5);
		stack.push(10);
		stack.push(54);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
	}

	public Stack(int size) {
		top = -1;
		maxSize = size;
		array = new int[maxSize];
	}
	
	public void push(int element) {
		if(isFull()) {
			System.out.println("Stack is full");
		}
		else {
			top++;
			array[top] = element;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else {
			int element = array[top];
			top--;
			return element;
		}
	}
	
	public int peek() {
		return array[top];
	}
	
	public boolean isEmpty() {
		if(top<0) {
			return true;
		}
		else {
			return false;
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
	
}
