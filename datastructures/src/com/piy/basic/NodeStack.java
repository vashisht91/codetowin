package com.piy.basic;

public class NodeStack {
	private int maxSize;
	private Node[] array;
	private int top;
	
	public NodeStack() {
		super();
		this.maxSize = 10;
		array = (Node[]) new Object[maxSize];
		top = -1;
	}
	
	public NodeStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		array = (Node[]) new Object[maxSize];
		top = -1;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public Node[] getArray() {
		return array;
	}
	public void setArray(Node[] array) {
		this.array = array;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
	public boolean isFull() {
		if(top == maxSize-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(top ==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	public void push(Node element) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		array[++top] = element;
	}
	
	public Node pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		Node element = array[top];
		top--;
		return element;
	}
	
	public Node peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		
		return array[top];
	}
}
