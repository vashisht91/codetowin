package thread;

import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) throws IOException {
		System.out.println("Main method");
		Process process = Runtime.getRuntime().exec("Explorer");
		System.out.println("Explorer started.");
		System.out.println(Runtime.getRuntime().freeMemory());
	}

}
