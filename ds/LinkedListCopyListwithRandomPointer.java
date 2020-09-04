package ds;

import java.util.*;

public class LinkedListCopyListwithRandomPointer {

	public static void main(String[] args) {

	}

	 public Node copyRandomList(Node head) {
	        Node newHead = null;

	        Node curr = head, newCurr=null;
	        Node prev = null, newPrev=null;
	        Queue<Node> q = new LinkedList<>();
	        Map<Integer, Node> map = new HashMap<>();
	        
	        while(curr != null) {
	            Node node = new Node(curr.val);
	            if(newHead == null) {
	                newHead = node;
	                newCurr = node;
	                node.random = curr.random;
	                q.add(newHead);
	                map.put(curr.val, node);
	            }
	            else {
	                if(newPrev == null)
	                    newPrev = newCurr;
	                else
	                    newPrev.next = newCurr;
	                newPrev = newCurr;
	                newCurr = node;
	                if(map.get(curr.random)!=null) {
	                    node.random = map.get(curr.random);
	                }
	                else{
	                    node.random = curr.random;
	                    map.put(curr.val, node);
	                    q.add(node);
	                }
	            }
	            prev = curr;
	            curr = curr.next;
	        }
	        newPrev.next = newCurr;
	        newCurr.next = null;
	        
	        while(!q.isEmpty()) {
	            Node fin = q.remove();
	            if(fin.random != null)
	                fin.random = map.get(fin.random.val);
	            else
	                fin.random = null;
	        }
	        
	        return newHead;
	    }
	
	 
	 class Node {
		    int val;
		    Node next;
		    Node random;

		    public Node(int val) {
		        this.val = val;
		        this.next = null;
		        this.random = null;
		    }
		}
}
