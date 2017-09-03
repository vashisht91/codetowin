package com.piy.basic;

public class StackUsingLinkedList {
	private Node rootNode;
	private int size;
	
	public static void main(String[] args) {
		StackUsingLinkedList list = new StackUsingLinkedList();
		list.push(10);
		list.push(20);
		list.push(30);
		System.out.println(list.getSize());
		System.out.println(list.peek().getData());
		System.out.println(list.pop().getData());
		System.out.println(list.peek().getData());
		System.out.println(list.getSize());
	}

	public void push(int data) {
		if(size == 0) {
			rootNode = new Node();
			Node thisNode = new Node(data);
			rootNode.setNextNode(thisNode);
		}
		else {
			Node thisNode = new Node(data);
			thisNode.setNextNode(rootNode.getNextNode());
			rootNode.setNextNode(thisNode);
		}
		size++;
	}
	
	public Node pop() {
		if(size == 0) {
			return null;
		}
		else {
			Node thisNode = rootNode.getNextNode();
			rootNode.setNextNode(thisNode.getNextNode());
			size--;
			return thisNode;
		}
	}
	
	public Node peek() {
		return rootNode.getNextNode();
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
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

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public boolean isEmpty () {
			if(this.getData() == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
}
