package thread;

public class DeadlockDemo {

	public static void main(String[] args) throws InterruptedException {
		final String r1 = "A";
		final String r2 = "B";
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized(r1) {
					System.out.println("r1 is locked : "+r1);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(r2) {
						System.out.println("r2 is locked : "+r2);
					}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized(r2) {
					System.out.println("r2 is locked : "+r2);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(r1) {
						System.out.println("r1 is locked : "+r1);
					}
				}
			}
		};
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Completed Main");
	}
	
}
