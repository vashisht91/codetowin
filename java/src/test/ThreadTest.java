package test;

import java.util.concurrent.SynchronousQueue;

public class ThreadTest implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread "+Thread.currentThread().getId());
	}

}

class Demo {
	public static void main(String[] args) {
/*//		ThreadTest t = new ThreadTest();
		Thread t = new Thread(new ThreadTest());
		t.start();*/
		
		 try
	        {
	             
	            System.out.println("Entering into Deadlock");
	             
	            Thread.currentThread().join();
	             
	            // the following statement will never execute
	            System.out.println("This statement will never execute");
	             
	        } 
	         
	        catch (InterruptedException e) 
	        {
	            e.printStackTrace();
	        }
	}
}
