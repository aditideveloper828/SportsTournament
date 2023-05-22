package main;

/**
 * Custom exception class indicating that the game cannot be played,
 * and therefore a new match cannot be initiated.
 */

public class CannotPlay extends Exception{
	
	/**
	 * The serial version UID for this class
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new CannotPlay exception with no specified detail message.
     */
	public CannotPlay() {
		super();
	}
	
	/**
     * Constructs a new CannotPlay exception with the specified detail message, game environment, and duration.
     * The exception message is printed along with the final status of the game before exiting the program.
     *
     * @param message  The detail message explaining the reason for the exception.
     * @param game     The GameEnvironment object representing the game.
     * @param duration The selected season duration.
     */
	public CannotPlay(String message, GameEnvironment game, int duration) {
		super();
		System.out.println(message);
		System.out.println("Your Final Status!!!");
	    System.out.println("Team Name: "+game.getTeamName());
	    System.out.println("Selected Season Duration: "+duration);
		System.out.println("Final Balance: "+game.getBalance());
		System.out.println("Total Points: "+game.getPoints());
		System.exit(0);
		
	}

}
