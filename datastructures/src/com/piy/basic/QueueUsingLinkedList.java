package com.piy.basic;

public class QueueUsingLinkedList {
	private Node rear;
	private Node front;
	private int size;
	
	
	public static void main(String[] args) {
		QueueUsingLinkedList queue= new QueueUsingLinkedList();
		System.out.println(queue.getSize());
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.getSize());
		queue.dequeue();
		System.out.println(queue.getSize());
		
	}

	public Node enqueue(int data) {
		Node thisNode = new Node(data);
		if(size==0) {
			rear = new Node();
			front = new Node();
			rear.setNextNode(thisNode);
			front.setNextNode(thisNode);
		}
		else {
			rear.getNextNode().setNextNode(thisNode);
			rear.setNextNode(thisNode);
		}
		size++;
		return thisNode;
	}
	
	public Node dequeue() {
		if(size==0) {
			return null;
		}
		else {
			Node thisNode = front.getNextNode();
			front.setNextNode(thisNode.getNextNode());
			size--;
			return thisNode;
		}
	}
	
	public int front() {
		return front.getNextNode().getData();
	}
	
	public Node getRear() {
		return rear;
	}

	public void setRear(Node rear) {
		this.rear = rear;
	}

	public Node getFront() {
		return front;
	}

	public void setFront(Node front) {
		this.front = front;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private class Node {
		private int data;
		private Node nextNode;
		
		public Node() {}
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node node) {
			this.nextNode = node;
		}
		
		public boolean isEmpty() {
			if(data==0) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}

}
