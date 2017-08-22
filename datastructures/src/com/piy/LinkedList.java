package com.piy;

public class LinkedList {
	
	private Node rootNode;
	private int size;
	
	public static void main(String args[]) {
		
		LinkedList list = new LinkedList();
		System.out.println(list.getSize());
		list.add(4);
		list.add(15);
		System.out.println(list.getSize());
		list.add(46);
		list.add(9);
		list.add(10);
		System.out.println(list.find(46).getData());
		System.out.println(list.getSize());
		System.out.println(list.remove(9));
		System.out.println(list.getSize());
		
	}
	
	public LinkedList() {
		rootNode = new Node();
		size = 0;
	}
	
	public Node add(int data) {
		if(this.getSize()==0) {
			rootNode = new Node(data);
			this.setSize(this.getSize()+1);
		}
		else {
			Node newNode = new Node(data, rootNode);
			rootNode = newNode;
			this.setSize(this.getSize()+1);
		}
		return rootNode;
	}
	
	public Node find(int data) {
		
		Node searchNode = rootNode;
		while(searchNode!=null) {
			if(searchNode.getData()==data) {
				return searchNode;
			}
			searchNode = searchNode.getNextNode();
		}
		return null;
	}
	
	public boolean remove(int data) {
		 Node thisNode = rootNode;
		 Node prevNode = null;
		 
		 while(thisNode!=null) {
			 if(thisNode.getData()==data) {
				 prevNode.setNextNode(thisNode.getNextNode());
				 this.setSize(this.getSize()-1);;
				 return true;
			 }
			 prevNode = thisNode;
			 thisNode = thisNode.getNextNode();
		 }
		 return false;		 
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
		
		public Node(int val) {
			data = val;
			nextNode = null;
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

}
