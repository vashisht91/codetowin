package thread;

public class JoinDemo implements Runnable{

	public static void main(String[] args) {
		System.out.println("Main Thread : "+Thread.currentThread().getName());
		Thread t = new Thread(new JoinDemo());
		t.start();
		try {
			t.join(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 ; i < 25 ; i++) {
			System.out.println("Main Thread : "+Thread.currentThread().getName());
		}
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 25 ; i++) {
			System.out.println("Thread : "+Thread.currentThread().getName());
		}
		
	}

}
