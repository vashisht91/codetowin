package ds;

import java.util.*;

class MedianFinder {

    private Queue<Long> small = new PriorityQueue(),
                        large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() - small.peek()) / 2.0;
    }
    
    
    public static void main(String[] args) {
    	
    	  MedianFinder obj = new MedianFinder();
    	  obj.addNum(1);
    	  System.out.println(obj.findMedian());
    	  obj.addNum(2);
    	  System.out.println(obj.findMedian());
    	  obj.addNum(3);
    	  System.out.println(obj.findMedian());
    }
}
