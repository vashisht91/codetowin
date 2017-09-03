package com.piy.basic;

public class Queue {

	private int maxSize;
	private int[] array;
	private int rear;
	
	public static void main(String args[]) {
		Queue queue = new Queue(20);
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println(queue.peek());
		queue.enqueue(12);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
	
	public Queue(int size) {
		maxSize = size;
		array = new int[maxSize];
		rear = -1;	
	}
	
	public void enqueue(int element) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		else {
			rear++;
			array[rear] = element;
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		else {
			int element = array[0];
			if(rear!=0) {
				for(int i=0;i<=rear;i++) {
					array[i] = array[i+1];
				}
			}
			rear--;
			return element;
		}
	}
	
	public int peek() {
		return array[0];
	}
	
	public boolean isEmpty() {
		if(rear==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(rear==maxSize-1) {
			return true;
		}
		else {
			return false;
		}
	}
}
