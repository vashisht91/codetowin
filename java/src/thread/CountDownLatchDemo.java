package thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		Worker w1 = new Worker(latch, 1000, "A");
		Worker w2 = new Worker(latch, 2000, "B");
		Worker w3 = new Worker(latch, 3000, "C");
		Worker w4 = new Worker(latch, 4000, "D");
		
		w1.start();
		w2.start();
		w3.start();
		w4.start();
		
		latch.await();
		
		System.out.println("Main thread executes : "+Thread.currentThread().getName());
	}

}

class Worker extends Thread {
	CountDownLatch latch;
	int delay;
	String threadName;
	
	public Worker(CountDownLatch latch, int delay, String threadName) {
		super(threadName);
		this.latch = latch;
		this.delay = delay;
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		System.out.println("Thread name is : "+threadName);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Thread Completed : "+threadName);

	}
}
