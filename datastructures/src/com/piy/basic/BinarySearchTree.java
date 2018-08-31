package com.piy.basic;

public class BinarySearchTree {
	private Node rootNode;

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(20);
		bst.insert(8);
		System.out.println(bst.search(8).getData());
	}

	public void insert(int data) {
		if(rootNode==null) {
			rootNode = new Node(data);
		}
		else {
			Node currentNode = rootNode;
			Node parentNode;
			while(true) {
				parentNode = currentNode;
				if(data <= currentNode.getData()) {
					currentNode = currentNode.getLeftNode();
					if(currentNode == null) {
						parentNode.setLeftNode(new Node(data));
						return;
					}
				}
				else {
					currentNode = currentNode.getRightNode();
					if(currentNode == null) {
						parentNode.setRightNode(new Node(data));
						return;
					}
				}
			}
		}
	}
	
	public Node search(int data) {
		if(rootNode == null) {
			return null;
		}
		else {
			Node currentNode = rootNode;
			while(currentNode != null) {
				if(data == currentNode.getData()) {
					return currentNode;
				}
				else if(data < currentNode.getData()) {
					currentNode = currentNode.getLeftNode();
				}
				else {
					currentNode = currentNode.getRightNode();
				}
			}
			return null;
		}
	}
	
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	private class Node {
		private int data;
		private Node leftNode;
		private Node rightNode;
		
		public Node() {
			this.data = 0;
		}
		
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
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		
	}
}
