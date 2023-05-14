/**
 * 
 */
package main;

/**
 * @author Aditi Sharma
 *
 */
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
//have to complete comments
///////////////add in method for taking input to avoid repeating code
public final class UserInterface {
	private static PurchasableManager market = new PurchasableManager();
	private static GameEnvironment thisGame;
	private static Match thisMatch;
	
	
	
	private static void setUp() {
		//make athletes and items
		//make athletes
		//change this method to remove duplicate code
		FileRead athleteFile = new FileRead("AthleteProfiles");
		ArrayList<String> athleteProfiles = athleteFile.getData();
		for (int i = 1; i < athleteProfiles.size(); i++) {
			String[] characterData = athleteProfiles.get(i).split(";",0);
//			System.out.println(characterData);
			int [] stats = new int[5];
			// System.out.println(i);
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
		
		//making items
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
	private static void goToMarket() {
		//make purchases / sell;
		System.out.println("Welcome to the market");
		Purchase athletes = new Purchase("ATHLETE", market, thisGame);
		Purchase items = new Purchase("ITEM", market, thisGame);
		
	}
	
	
	
	private static void viewGame() {
		//view club stats;
		
		System.out.println("Welcome to the Club Room!");
		System.out.println("Team Name: "+thisGame.getTeamName());
		System.out.println("Balance: "+thisGame.getBalance());
		System.out.println("Weeks Remaining in Season: "+thisGame.getWeeks());
		System.out.println();
		System.out.println("Your Team: ");
		thisGame.displayTeam();	    
	    System.out.println("Your Items: ");
	    thisGame.displayItems();
	    
		
	}
	
	
	public static boolean chooseOpTeam() {
		OppositionTeam team1 = new OppositionTeam(market, "Team 1");
		OppositionTeam team2 = new OppositionTeam(market, "Team 2");
		OppositionTeam team3 = new OppositionTeam(market, "Team 3");
		
		Scanner input2 = new Scanner(System.in);
		
		// insert a dropdown here for selecting a team
		System.out.println("Choose your opponent:");
		System.out.println(team1.getOpTeamName());
		System.out.println(team2.getOpTeamName());
		System.out.println(team3.getOpTeamName());
		System.out.println("Take a BYE"); 
	    String opTeamSelect = input2.nextLine();
	    
	    // currently just calling team2, but will change to a dropdown select with GUI
	    if (opTeamSelect != "BYE"){
	    	if (opTeamSelect == team1.getOpTeamName()) {
	    		thisMatch = new Match(thisGame, team1);
	    		
	    	}
	    	else if (opTeamSelect == team2.getOpTeamName()){
	    		thisMatch = new Match(thisGame, team2);
	    	}
	    	else {
	    		thisMatch = new Match(thisGame, team3);
	    	}
	    	
	    	return true;	
	    }
	    byeWeek();
	    return false;
	    
	    
	    
	}
		
	private static void byeWeek() {
		// show items available to use while the team is resting
		thisGame.displayItems();
		thisGame.teamStaminaRefill();
		thisGame.reduceWeek();
	}
	

	public static void main(String[] args) {
		setUp();
		
		Scanner input = new Scanner(System.in);

	    System.out.println("Enter Team Name:");
	    String name = input.nextLine();
	    
	    System.out.println("Enter Season Duration:");
	    // insert a number select or slider here to reduce potential for errors
	    int weeks = input.nextInt();
	    
	    thisGame = new GameEnvironment(name, weeks);
	    
	    System.out.println("It's Time To Make Your Team!");
	    goToMarket();
	    
	    System.out.println("Enter Diffuculty (must be 1 or 2):");
	    int difficulty = input.nextInt();
	    String x = input.nextLine();
	    thisGame.setDifficulty(difficulty);
	   
	    System.out.println("Let's Play!");
	    
	    //Start playing
	    while (thisGame.getWeeks() > 0) {
	    	viewGame();
	    	thisGame.reduceWeek();
	    	
	    	System.out.println("Would you like to visit the market? (y/n)");
		    String choice = input.nextLine();
		    choice = choice.toUpperCase();
		    if (choice == "Y") {
		    	//This check is not currently working
		    	goToMarket();
		    }

		    //check if you want to play match or have a buy -- then use items
		    //replace opteam with the chosen opposition team.
		    boolean playedGame = chooseOpTeam();
		    Random randInt = new Random();
		    if (playedGame) {
		    	boolean result = thisMatch.matchWon();
		    	if (result) {
		    		System.out.println("Congratulations! You won this weeks's match!");
		    		thisGame.increaseBalance(50*thisMatch.getTeamTotal()/thisGame.getDifficulty()); 
		    	}
		    	else {
		    		System.out.println("You lost. Better luck next time!");
		    	}
		    	
		    	
		    }
	    	
			Random randomEvent = new Random();
			int eventOccurs = randomEvent.nextInt(100);
			if (eventOccurs < 100/thisGame.getDifficulty()) {
				RandomEvent event = new RandomEvent(thisGame);
			}
	    	
	    	//find out win or loss, display results, then add money
	    	
	    // change so includes byes and opposing teams
	    }
	    input.close();
	    
	    System.out.println("Your Final Status!!!");
	    viewGame();
	    

	}

}
