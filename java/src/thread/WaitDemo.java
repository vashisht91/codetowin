package thread;

import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

public class WaitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		PC pc = new PC();
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		t.start();
		t1.start();
		t.join();
		t1.join();;
	}

	static class PC {
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 1;
		
		public void produce() throws InterruptedException {
			int value = 0;
			while(true) {
				synchronized(this) {
					if(list.size()==capacity)
						wait();
//					System.out.println("Producer thread" + Thread.currentThread().getName());
					System.out.println("Producer produced-"+ value);
					list.add(value++);
					notify();
					Thread.sleep(100);
//					System.out.println("Producer resumed"+ Thread.currentThread().getName());
				}
			}
		}
		
		public void consume() throws InterruptedException {
			while(true) {
				synchronized(this) {
					if(list.size()==0)
						wait();
//					System.out.println("Consumer thread"+ Thread.currentThread().getName());
					int value = list.removeFirst();
					System.out.println("Consumer consumed-"+ value);
					notify();
//					System.out.println("Consumer resumed"+ Thread.currentThread().getName());
					Thread.sleep(100);
				}
			}
		}
	}
}
