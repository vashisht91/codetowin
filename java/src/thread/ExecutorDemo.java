package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		Runnable r1 = new Task("1");
		Runnable r2 = new Task("2");
		Runnable r3 = new Task("3");
		Runnable r4 = new Task("4");
		Runnable r5 = new Task("5");
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		pool.shutdown();
	}


	public static class Task implements Runnable {
		String name;
		
		public Task(String n) {
			name = n;
			System.out.println("Task name "+ name);
		}
		
		@Override
		public void run() {
			for(int i=0; i<5; i++) {
				System.out.println("Task "+ name + " iteration "+i);
			}
		}
	}
}
