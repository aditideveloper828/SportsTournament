/**
 * 
 */
package main;

/**
 * @author Aditi Sharma
 *
 */
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
//have to complete comments
public final class UserInterface {
	
	
	
	
	
	private static void setUp() {
		//make athletes and items
		//make opposition teams
		
		
	}

	public static void main(String[] args) {
		setUp();
		
		Scanner getBasics = new Scanner(System.in);

	    System.out.println("Enter Team Name:");
	    String name = getBasics.nextLine();
	    
	    System.out.println("Enter Season Duration:");
	    int weeks = getBasics.nextInt();
	    
	    System.out.println("Enter Diffuculty (must be 1 or 2):");
	    int difficulty = getBasics.nextInt();
	    getBasics.close();
	    
	    @SuppressWarnings("unused")
		GameEnvironment game = new GameEnvironment(name, difficulty, weeks);
	    int[] stats = new int[] {8, 5, 100, 30, 60};
		Athlete theresaWise = new Athlete("Theresa Wise", stats);
		new PurchasableManager(theresaWise); //check what this is doing

	    Purchase first = new Purchase("ATHLETES");
	    //testing
//	    int check = game.getWeeks();
//	    System.out.println(check);
//	    game.reduceWeek();
//	    check = game.getWeeks();
//	    System.out.println(check);
//	    System.out.println(game.getDifficulty());
//	    System.out.println(game.getTeamName());
	    
	    
	    //Figure out how to select team;

	    // Figure out how to start a game
	    

	}

}
