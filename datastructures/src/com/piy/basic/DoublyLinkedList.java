package com.piy.basic;

public class DoublyLinkedList {
	private Node rootNode;
	private int size;
	
	public static void main(String argss[]) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addNodeAtBeginning(10);
		list.addNodeAtBeginning(20);

		System.out.println(list.find(10).getData());
		list.addNodeAtBeginning(30);
		list.addNodeAtBeginning(40);
		list.addNodeAtBeginning(50);
//		System.out.println(list.delete(30));
		list.printLinkedList();	
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

	public void addNodeAtBeginning(int data) {
		if(size==0) {
			rootNode = new Node();
			Node node = new Node(data);
			rootNode.setNextNode(node);
		}
		else {
			Node node = new Node(data);
			Node firstNode = rootNode.getNextNode();
			node.setNextNode(firstNode);
			firstNode.setPrevNode(node);
			rootNode.setNextNode(node);
		}
		size++;	
	}
	
	public Node find(int data) {
		if(size==0) {
			return null;
		}
		else {
			Node thisNode = rootNode;
			do {
				thisNode = thisNode.getNextNode();
				if(thisNode.getData()==data) {
					return thisNode;
				}
			} while(thisNode.getNextNode()!=null);
			return null;
		}
	}
	
	public boolean delete(int data) {
		if(size == 0 ) {
			return false;
		}
		else {
			Node thisNode = rootNode;
			do{
				thisNode = thisNode.getNextNode();
				if(thisNode.getData() == data) {
					thisNode.getPrevNode().setNextNode(thisNode.getNextNode());
					thisNode.getNextNode().setPrevNode(thisNode.getPrevNode());
					size--;
					return true;
				}
			} while(thisNode.getNextNode()!=null);
			return false;
		}
	}
	
	public void printLinkedList() {
		if(size==0) {
			return;
		}
		else {
			Node thisNode = rootNode;
			int count = 0;
			do {
				if(count!=0){
					System.out.print(" --> ");
				}
				thisNode = thisNode.getNextNode();
				System.out.print(thisNode.getData());
				count++;
			} while(thisNode.getNextNode() != null);
		}
	}
	
	private class Node {
		private int data;
		private Node nextNode;
		private Node prevNode;
		
		public Node() {}
		
		public Node(int data) {
			super();
			this.data = data;
		}

		public Node getPrevNode() {
			return prevNode;
		}
		
		public void setPrevNode(Node prevNode) {
			this.prevNode = prevNode;
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
		
		public boolean isEmpty() {
			if(this.getData()==0){
				return true;
			}
			else {
				return false;
			}
		}
		
	}
}
