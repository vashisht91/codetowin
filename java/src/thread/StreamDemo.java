package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class StreamDemo {
	static int count=0;
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		for(int i=0;i<50;i++) {
			l.add("A"+i);
		}
		
			StreamSupport.stream(l.spliterator(), true).parallel().forEach(shipment -> {
				System.out.println("Thread is : "+Thread.currentThread().getName()+" "+shipment+" count : "+ ++count);
				System.out.println("this is : "+shipment);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			
/*			StreamSupport.stream(l.spliterator(), true).sequential().forEach(shipment -> {
				System.out.println("Thread is : "+Thread.currentThread().getName()+" "+shipment+" count : "+ ++count);
				System.out.println("this is : "+shipment);
			});
*/	}

}
