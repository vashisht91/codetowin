package com.piy;

public class LinkedList {
	
	private Node rootNode;
	private int size;
	
	public static void main(String args[]) {
		
		LinkedList list = new LinkedList();
		System.out.println(list.getSize());
		list.addAtBeginning(4);
		list.addAtBeginning(15);
		System.out.println(list.getSize());
		list.addAtBeginning(46);
		list.addAtBeginning(9);
		list.addAtBeginning(10);
		System.out.println(list.find(46).getData());
		System.out.println(list.getSize());
		System.out.println(list.remove(9));
		System.out.println(list.getSize());
		System.out.println(list.find(4621));
		System.out.println(list.remove(46));
		list.addAtNthPosition(12, 4);
		list.addAtNthPosition(22, 5);
		System.out.println(list.removeAtNthPosition(3));
		list.printLinkedList();
		list.reverseLinkedList();
		list.printLinkedListUsingRecursion(list.getRootNode());	System.out.println("");
		list.printReverseLinkedListUsingRecursion(list.getRootNode()); System.out.println("");
		list.reverseLinkedListUsingRecursion(list.getRootNode().getNextNode());
		list.printLinkedList();
	}
	
	public LinkedList() {
		rootNode = new Node();
		size = 0;
	}
	
	
	//inserting at the beginning
	public Node addAtBeginning(int data) {
		if(this.getSize()==0) {
			Node node = new Node(data);
			rootNode.setNextNode(node);
			this.setSize(this.getSize()+1);
		}
		else {
			Node newNode = new Node(data, rootNode.getNextNode());
			rootNode.setNextNode(newNode);
			this.setSize(this.getSize()+1);
		}
		return rootNode;
	}
	
	public Node find(int data) {
		
		Node searchNode = rootNode;
		while(searchNode!=null) {
			if(searchNode	.getData()==data) {
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
				 if(prevNode!=null) {
					 prevNode.setNextNode(thisNode.getNextNode());
				 }
				 this.setSize(this.getSize()-1);
				 return true;
			 }
			 prevNode = thisNode;
			 thisNode = thisNode.getNextNode();
		 }
		 return false;		 
	}

	public Node addAtNthPosition(int data, int position) {
		if(position > size+1 || data<1) {
			return null;
		}
		else {
			int count=1;
			Node thisNode = rootNode.getNextNode();
			Node prevNode = null;
			while(count<position) {
				prevNode = thisNode;
				thisNode = thisNode.getNextNode();
				count++;
			}
			Node newNode = new Node(data);
			newNode.setNextNode(thisNode);
			if(count==1) {
				rootNode.setNextNode(newNode);
			}
			else {
				prevNode.setNextNode(newNode);
			}
			size++;
			return newNode;
			
		}
	}
	
	public boolean removeAtNthPosition(int position) {
		if(position > size || position <1) {
			return false;
		}
		else {
			
			Node thisNode = rootNode.nextNode;
			Node prevNode = null;
			int count = 1;
			if(position == 1) {
				rootNode.setNextNode(thisNode.getNextNode());
			}
			else {
				while(count!=position) {
					prevNode = thisNode;
					thisNode = thisNode.getNextNode();
					count++;
				}
				prevNode.setNextNode(thisNode.getNextNode());
			}
			size--;
			return true;
		}
	}
	
	public void reverseLinkedList() {
		Node thisNode, prevNode, successorNode;
		thisNode = rootNode.getNextNode();
		prevNode = null;
		while(thisNode.getNextNode()!=null) {
			successorNode = thisNode.getNextNode();
			thisNode.setNextNode(prevNode);
			prevNode = thisNode;
			thisNode = successorNode;
		}
		thisNode.setNextNode(prevNode);
		rootNode.setNextNode(thisNode);
		printLinkedList();
	}
	
//	Need to pass the first node of the linked list (not the root node)
	public void reverseLinkedListUsingRecursion(Node node) {
		if(node.getNextNode() == null) {
			rootNode.setNextNode(node);
			return;
		}
		reverseLinkedListUsingRecursion(node.getNextNode());
		node.getNextNode().setNextNode(node);
		node.setNextNode(null);
		
	}
	
	public void printLinkedList() {
		int count=0;
		System.out.print("[");
		Node node = this.getRootNode().getNextNode();
		while(count<size) {
			System.out.print(node.getData()+" --> ");
			node= node.getNextNode();
			count++;
		}
		System.out.println("null]");
	}
	
	public void printLinkedListUsingRecursion(Node thisNode) {
		if(thisNode==null) {
			return;
		}
		System.out.print(" "+thisNode.getData());
		printLinkedListUsingRecursion(thisNode.getNextNode());
	}
	
	
	public void printReverseLinkedListUsingRecursion(Node thisNode) {
		if(thisNode == null) {
			return;
		}
		printReverseLinkedListUsingRecursion(thisNode.getNextNode());
		System.out.print(" "+thisNode.getData());
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
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
