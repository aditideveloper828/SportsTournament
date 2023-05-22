package main;

import java.io.*;  
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
	
	public String readAllLinesWithStream(BufferedReader reader) {
	    return reader.lines()
	      .collect(Collectors.joining(System.lineSeparator()));
	} 
	
	/**
	 * Reads data from a file and populates the 'data' ArrayList.
	 */
	private void read() {
		//File file = new File(fileName);
		//FileInputStream inputStream = new FileInputStream(file);
		//InputStreamReader streamReader = new InputStreamReader(inputStream);
		//BufferedReader buffer = new BufferedReader(streamReader);
		
		InputStream in = getClass().getResourceAsStream(fileName);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		System.out.println("Up to this point");
		String allData = readAllLinesWithStream(reader);
		System.out.println(allData);
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