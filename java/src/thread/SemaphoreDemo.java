package thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore sema = new Semaphore(1);
		MyThread t1 = new MyThread("A", sema);
		MyThread t2 = new MyThread("B", sema);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Shared {
	public static int count = 0;
}

class MyThread extends Thread {
	String threadName;
	Semaphore sem;
		
	public MyThread(String threadName, Semaphore sem) {
		super(threadName);
		this.threadName = threadName;
		this.sem = sem;
	}

	@Override
	public void run() {
		if(threadName.equalsIgnoreCase("A")) {
			System.out.println("Thread "+threadName+" waiting to acquire lock");
		/*	try {
				sem.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
*/			System.out.println("Thread "+threadName+" acquired lock");
			for(int i=0;i<5;i++) {
				System.out.println("Count it : "+ ++Shared.count);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			sem.release();
			System.out.println("Thread "+threadName+" released lock");
		}
		else {
			System.out.println("Thread "+threadName+" waiting to acquire lock");
/*			try {
				sem.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
*/			System.out.println("Thread "+threadName+" acquired lock");
			for(int i=0;i<5;i++) {
				System.out.println("Count it : "+ --Shared.count);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			sem.release();
			System.out.println("Thread "+threadName+" released lock");
		}
	}
	
}
