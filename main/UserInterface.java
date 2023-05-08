/**
 * 
 */
package main;

/**
 * @author Aditi Sharma
 *
 */
import java.util.Scanner;
//have to complete comments
public final class UserInterface {

	public static void main(String[] args) {
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
		Athlete theresaWise = new Athlete("Theresa Wise", 8, 5, 100);
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
