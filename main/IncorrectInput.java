package main;

/**
 * An exception class representing incorrect input.
 * Extends the IllegalArgumentException class.
 * 
 * @author Aditi Sharma
 */

public class IncorrectInput extends IllegalArgumentException{

	/**
     * Constructs a new IncorrectInput object with no detail message.
     */
	public IncorrectInput() {
		super();
	}
	
	/**
     * Constructs a new IncorrectInput object with the specified detail message.
     *
     * @param message the detail message
     */
	public IncorrectInput(String message) {
		super(message);
	}

}
