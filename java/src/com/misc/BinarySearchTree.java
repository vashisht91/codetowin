package com.misc;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
    
    
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        Node thisNode = root;
        do{
        	if(thisNode.getValue()==value) {
        		return true;
        	}
        	else{
        		if(value<thisNode.getValue()){
        			thisNode = thisNode.getLeft();
        		}
        		else{
        			thisNode = thisNode.getRight();
        		}
        	}
        } while(thisNode !=null);
    	
    	return false;
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        
        System.out.println(contains(n2, 3));
    }
}