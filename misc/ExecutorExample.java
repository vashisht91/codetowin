package misc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {


/*		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		thread1.start();
		thread2.start();
*/
		
		Task t1 = new Task();
		TaskNew t2 = new TaskNew();
		ExecutorService ex = Executors.newFixedThreadPool(10);
		ex.execute(t1);
		ex.execute(t1);
		ex.execute(t1);
		
		ExecutorService ex1 = Executors.newCachedThreadPool();
		Future<Integer> f1 = ex1.submit(t2);
		Future<Integer> f2 = ex1.submit(t2);
		Future<Integer> f3 = ex1.submit(t2);
		
		Integer i1 = f1.get();
		Integer i2 = f2.get();
		Integer i3 = f3.get();
		
		System.out.println(i1+i2+i3);
		
		ex.shutdown();
		ex1.shutdown();
		
	}

}

class TaskNew implements Callable {
	@Override
	public Object call() throws Exception {
		int i=0;
		for(; i<5; i++)
		System.out.println("This is Task under Callable thread : "+Thread.currentThread().getName());
		return i;
	}
	
}

class Task implements Runnable {

	@Override
	public void run() {
		for(int i=0 ; i<5; i++)
			System.out.println("This is Task under thread : "+Thread.currentThread().getName());
	}
	
}