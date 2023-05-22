package main;

/**
 * An exception class representing incorrect input.
 * Extends the IllegalArgumentException class.
 */

public class IncorrectInput extends IllegalArgumentException{

	/**
	 * The serial version UID for this class
	 */
	private static final long serialVersionUID = 1L;

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
