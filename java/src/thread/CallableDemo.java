package thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer>[] task = new FutureTask[5];
		
		for(int i=0; i<5 ; i++) {
			Callable<Integer> callable = new CallableExample();
			task[i] = new FutureTask(callable);
			Thread t = new Thread(task[i]);
			t.start();
		}
		
		  for (int i = 0; i < 5; i++)
		    {
		      System.out.println(task[i].get());
		    }
	}
}

class CallableExample implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Random gen = new Random();
		Integer num = gen.nextInt(5);
		Thread.sleep(num * 1000);
		return num;
	}
	
}
