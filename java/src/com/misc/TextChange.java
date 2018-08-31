package com.misc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextChange {
	public static Logger logger = LoggerFactory.getLogger(TextChange.class);
	public static void main(String[] args) throws InterruptedException {
		  
		convertToDate();
		
			/*logger.debug("TextChange Started");
	        String timeElapsed = "00:01:13.541";
	        String processStartTime = "13:41:49.541";
	        String processEndTime = "13:56:03.083";
	        String filePath = "C:\\\\temp\\AutoPilotTimingReport.txt";
	        String operationName = "Transport Order Creation";
	        Path path = Paths.get(filePath);
	        boolean updatedFlag = false;
	        try {	
	            Files.createDirectories(path.getParent());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        if(Files.exists(path)) {
	            try {
	                List<String> line = Files.readAllLines(path);
	                for(int i=0; i<line.size();i++) {
            			if(line.get(i).trim().startsWith("Start Time for "+operationName)) {
            				line.set(i, "Start Time for " + operationName + " Operation is : " + processStartTime);
	                    
            				line.set(i+1, "End Time for " + operationName + " Operation is : " + processEndTime);
	                    
            				line.set(i+2, "Total Time Taken for " + operationName + " Operation  is : " + timeElapsed);
            				updatedFlag = true;
            				Files.write(path, line, StandardCharsets.UTF_8);
	                    }
	                }
	                
	                if(!updatedFlag) {
	                    String lines = "\n\nStart Time for " + operationName + " Operation is : " + processStartTime
	                            +"\nEnd Time for " + operationName + " Operation is : " + processEndTime
	                            +"\nTotal Time Taken for " + operationName + " Operation  is : " + timeElapsed;
	                    Files.write(path, lines.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	                }
	            } catch (IOException e) {
	               
	            }
	        }
	        else {
	            String lines = "\nStart Time for " + operationName + " Operation is : " + processStartTime
	                    +"\nEnd Time for " + operationName + " Operation is : " + processEndTime
	                    +"\nTotal Time Taken for " + operationName + " Operation  is : " + timeElapsed;
	            try {
	                Files.write(path, lines.getBytes());
	            } catch (IOException ex) {
	               
	            }
	        }*/
	}
//	1532587585358
	public static void convertToDate() {
//		String a = "1532417585358";
//		String b = ""+System.currentTimeMillis();
				
		long startTime = 1532417585358L;
		long endTime = System.currentTimeMillis();
		
//		long diff = Long.parseLong(b) - Long.parseLong(a);
		long diff = endTime-startTime;
//		System.out.println(startTime);
		Date startDate = new Date(startTime);
		Date endDate = new Date(endTime);
		Date diffDate = new Date(diff);
		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss.SSS");
		System.out.println(startDate + " : "+df.format(startDate));
		System.out.println(endDate + " : "+df.format(endDate));
		System.out.println(diffDate + " : "+df.format(diffDate));
		
		String hms = String.format("%02d:%02d:%02d.%03d", TimeUnit.MILLISECONDS.toHours(diff),
	            TimeUnit.MILLISECONDS.toMinutes(diff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff)),
	            TimeUnit.MILLISECONDS.toSeconds(diff) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff)),
	            TimeUnit.MILLISECONDS.toMillis(diff) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(diff)));
	    System.out.println(hms);
		
	}

}
