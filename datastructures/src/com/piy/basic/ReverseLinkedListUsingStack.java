package com.piy.basic;

public class ReverseLinkedListUsingStack {
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addAtBeginning(10);
		list.addAtBeginning(20);
		list.addAtBeginning(30);
		list.addAtBeginning(40);
		list.printLinkedList();
//		ReverseLinkedListUsingStack reverseLinkedListUsingStack = new ReverseLinkedListUsingStack();
		
//		NodeStack stack = reverseLinkedListUsingStack.new NodeStack(list.getSize());
		Stack stack = new Stack(list.getSize());
		
		Node thisNode = list.getRootNode();
		do{
			thisNode = thisNode.getNextNode();
			stack.push(thisNode.getData());
		} while(thisNode.getNextNode()!=null);
		
		LinkedList newList = new LinkedList();
		while(!stack.isEmpty()) {
			newList.addAtTheEnd(stack.pop());
		}
		newList.printLinkedList();
	}
	
/*	public NodeStack getStack() {
		return stack;
	}



	public void setStack(NodeStack stack) {
		this.stack = stack;
	}



	private class NodeStack {
		private int top;
		private int maxSize;
		private Node[] array;
		
		public NodeStack(int size) {
			top = -1;
			maxSize = size;
			array = new Node[maxSize];
		}
		
		public void push(Node element) {
			if(isFull()) {
				System.out.println("Stack is full");
			}
			else {
				top++;
				array[top] = element;
			}
		}
		
		public Node pop() {
			if(isEmpty()) {
				System.out.println("Stack is empty");
				return null;
			}
			else {
				Node element = array[top];
				top--;
				return element;
			}
		}
		
		public Node peek() {
			return array[top];
		}
		
		public boolean isEmpty() {
			if(top<0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean isFull() {
			if(top==maxSize-1) {
				return true;
			}
			else {
				return false;
			}
		}
	}
*/
}
