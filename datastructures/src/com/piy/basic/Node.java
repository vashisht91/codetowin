package com.piy.basic;

public class Node {
	private int data;
	private Node nextNode;
	
	public Node() {}
	
	public Node(int val) {
		super();
		this.data = val;
		this.nextNode = new Node();
	}
	
	public Node(int val, Node node) {
		data = val;
		nextNode = node;
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

	
}
