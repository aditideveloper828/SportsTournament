/**
 * 
 */
package main;

import java.util.ArrayList;
/**
 * @author Aditi Sharma
 *
 */
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
//have to complete comments
public final class UserInterface {
	private static PurchasableManager market = new PurchasableManager();
	private static GameEnvironment thisGame;
	
	
	
	private static void setUp() {
		//make athletes and items
		
		FileRead athleteFile = new FileRead("AthleteProfiles");
		ArrayList<String> athleteProfiles = athleteFile.getData();
		for (int i = 1; i < athleteProfiles.size(); i++) {
			String[] characterData = athleteProfiles.get(i).split(";",0);
			int [] stats = new int[5];
			for (int j = 0; j < 5; j++){
				stats[j] = 	 Integer.parseInt(characterData[j+2]);
			}
			String name = characterData[0] + " " + characterData[1];
			try {
				market.add(new Athlete(name, stats));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		FileRead itemFile = new FileRead("ItemDetails");
		ArrayList<String> itemDetails = itemFile.getData();
		for (int i = 1; i < itemDetails.size(); i++) {
			String[] itemData = itemDetails.get(i).split(";",0);
			int [] stats = new int[5];
			for (int j = 0; j < 4; j++){
				stats[j] = 	 Integer.parseInt(itemData[j+1]);
			}
			try {
				market.add(new Item(itemData[0], stats));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
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
	    
	    thisGame = new GameEnvironment(name, difficulty, weeks);
	    
	    
	    
	    @SuppressWarnings("unused")
		
		Athlete theresaWise = new Athlete("Theresa Wise",new int[] {8, 5, 100, 30, 60});
		PurchasableManager purchasable = new PurchasableManager();
		purchasable.add(theresaWise);
		//check what this is doing
	    Purchase first = new Purchase("ATHLETES", purchasable);
	    
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
