package thread;

public class ShutdownhookDemo {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("This is ShutdownHook running");
			}
		});
		
		System.out.println("Main method ending");
	}

}
