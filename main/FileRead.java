package main;

import java.io.*;  
import java.util.Scanner; 
import java.util.ArrayList;


public class FileRead {
	private String fileName;
	private ArrayList<String> data;
	
	public FileRead(String file) {
		this.data = new ArrayList<String>();
		fileName = file;
		this.read();
	}
	
	private void read() {
		try {
			File file = new File(fileName);
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(streamReader);

			String line;
			while((line = buffer.readLine()) != null){
				data.add(line);
			}
			buffer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error in FileRead:");
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("Error in FileRead:");
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getData() {
		return data;
	}
	

}