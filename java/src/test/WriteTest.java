package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriteTest {

	public static void main(String[] args) throws IOException {
		String filePath = "C:\\tools\\ap-tools\\data\\CleanupFiles\\AutoPilotSummaryReport.txt";
		File f = new File(filePath);
		/*f.getParentFile().mkdirs();*/
		System.out.println(f.exists());
		Path path = Paths.get(filePath);
        try {
			Files.createDirectories(path.getParent());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        String operationName = "Order Consolidation";
        String processStartTime = "13:11:30.268";
        String processEndTime = "13:19:59.709";
        String timeElapsed = "13:19:59.709";
        System.out.println(path.toString());
//        if(Files.exists(file)) {
 /*        List<String> line = Files.readAllLines(file);
//        }
        System.out.println(line.get(line.size()-1));
        if(line.get(line.size()-1).trim().startsWith("Start Time for Transport Order Creation1")) {
        	System.out.println("Starts");
//        	line.set(line.size()-2, "line 1");
//        	line.set(line.size()-1, "line 2");
        }
        else {
        	System.out.println("doesnt start");
        }
        
        Files.write(file, line, StandardCharsets.UTF_8);
        
		Paths.get(filePath);
		 try(BufferedReader bufferedReader = Files.newBufferedReader(file)) {
			 System.out.println("hi");
			 System.out.println(bufferedReader.lines().count());
			 System.out.println(bufferedReader.lines().r);
		 }
		 catch(IOException ex){
	            ex.printStackTrace();
	        }
		
		 try(BufferedWriter bufferedWriter = Files.newBufferedWriter(file, Charset.forName("UTF-8"),StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
			 	bufferedWriter.append("hi There");
	        }
	        catch(IOException ex){
	            ex.printStackTrace();
	        }*/
        
        
        if(Files.exists(path)) {
            try {
                List<String> line = Files.readAllLines(path);
                if(line.get(line.size()-1).trim().startsWith("Total Time Taken for "+operationName)) {
                    line.set(line.size()-3, "Start Time for " + operationName + " Operation is : " + processStartTime);
                    line.set(line.size()-2, "End Time for " + operationName + " Operation is : " + processEndTime);
                    line.set(line.size()-1, "Total Time Taken for " + operationName + " Operation  is : " + timeElapsed);
                    Files.write(path, line, StandardCharsets.UTF_8);
                }
                else {
                    String lines = "\nStart Time for " + operationName + " Operation is : " + processStartTime
                            +"\nEnd Time for " + operationName + " Operation is : " + processEndTime
                            +"\nTotal Time Taken for " + operationName + " Operation  is : " + timeElapsed;
//                    Files.write(path, lines.getBytes());
                    Files.write(path, lines.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
            } catch (IOException e) {
//                this.getLogger().error("Error writing the file at path : "+path.toString(), e);
            }
        }
        else {
            String lines = "\nStart Time for " + operationName + " Operation is : " + processStartTime
                    +"\nEnd Time for " + operationName + " Operation is : " + processEndTime
                    +"\nTotal Time Taken for " + operationName + " Operation  is : " + timeElapsed;
            try {
                Files.write(path, lines.getBytes());
            } catch (IOException ex) {
//                this.getLogger().error("Error writing file at path : "+path.toString(), ex);
            }
        }
	}
}
