package main;


import java.io.*;  
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents a utility class for reading data from a file.
 */
public class FileRead {
	private String fileName;
	private ArrayList<String> data;
	
	 /**
     * Creates a new FileRead object with the specified file name.
     *
     * @param file the name of the file to read
     */
	public FileRead(String file) {
		this.data = new ArrayList<String>();
		fileName = file;
		this.read();
	}
	
	/**
	 * Reads data from a file and populates the 'data' ArrayList.
	 */
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
	
	/**
     * Returns the data read from the file as an ArrayList of strings.
     *
     * @return the data read from the file
     */
	public ArrayList<String> getData() {
		return data;
	}
	

}