package com.piy.basic;

public class GenericStack <T> {
	private int maxSize;
	private T[] array;
	private int top;
	
	public GenericStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		array = (T[]) new Object[maxSize];
		top = -1;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public T[] getArray() {
		return array;
	}
	public void setArray(T[] array) {
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
	public void push(T element) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		array[++top] = element;
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		T element = array[top];
		top--;
		return element;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		
		return array[top];
	}
	
}
