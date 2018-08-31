package com.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ValidateJSON {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/temp/test.json");
		String s = "";
		StringBuilder sb = new StringBuilder();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			while((s = br.readLine())!=null) {
				sb.append(s);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(sb);
	}
}
