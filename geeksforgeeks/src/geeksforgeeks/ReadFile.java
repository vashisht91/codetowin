package geeksforgeeks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		ReadFile readFile = new ReadFile();
//		readFile.bufferedReaderMethod();
//		readFile.fileReaderMethod();
//		readFile.scannerMethod();
//		readFile.scannerMethodWithoutLoop();
//		readFile.readFileIntoList();
		readFile.readFileAsString();
		
		long total = System.currentTimeMillis()  - start;
		System.out.println("Total time : "+ total);
	}
	
	public void bufferedReaderMethod() throws IOException{
		File file = new File("C:\\Temp\\Test.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while((st = br.readLine())!=null) {
			System.out.println(st);
		}
	}
	
	public void fileReaderMethod() throws IOException {
		File file = new File("C:\\Temp\\Test.txt");
		FileReader fr = new FileReader(file);
		int i;
		while((i=fr.read())!=-1){
			System.out.print((char)i);
		}
	}
	
	public void scannerMethod() throws FileNotFoundException {
		File file = new File("C:\\Temp\\Test.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
	
	public void scannerMethodWithoutLoop() throws FileNotFoundException{
		File file = new File("C:\\Temp\\Test.txt");
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\Z");
		System.out.println(scanner.next());
	}
	
	public void readFileIntoList() throws IOException {
		List<String> list = Files.readAllLines(Paths.get("C:\\Temp\\Test.txt"));
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	public void readFileAsString() throws IOException{
		String str = new String(Files.readAllBytes(Paths.get("C:\\Temp\\Test.txt")));
		System.out.println(str);
	}
}
