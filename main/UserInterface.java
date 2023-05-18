/**
 * 
 */
package main;

/**
 * @author Aditi Sharma
 *
 */
import java.util.*;
//have to complete comments
///////////////add in method for taking input to avoid repeating code
////////////////fix scanner names
public final class UserInterface {
	private static PurchasableManager market = new PurchasableManager();
	private static GameEnvironment thisGame;
	private static Match thisMatch;
	
	
	private static void setUp() {
		//Move this to game environment
		//change this method to remove duplicate code
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
	
	private static void sell(String type) {
		Purchase sale = new Purchase(type, market, thisGame);
		Scanner picking = new Scanner(System.in);
		if (type == "ATHLETE"){
			thisGame.displayTeam();
			int sellType;
			int picked = 0;
			do {
				System.out.println("Enter 1 if you want to sell an active member and 2 if you want sell a reserve or -1 if you want to go home");
				sellType = picking.nextInt();
				if (sellType != -1){
					System.out.println("Choose your item to sell! (Enter in ID or -1 if you do not want to pick an item)");
					picked = picking.nextInt();
					if (picked != -1) {
						if (sellType == 1) {
							sale.sell(thisGame.getTeamMember(picked-1));
						}
						else {
							sale.sell(thisGame.getReserve(picked-1));
						}
					}
				}
				
			} while (picked != -1 && sellType != -1);
		}
		else {
			thisGame.displayItems();
			int picked;
			do {
								
				System.out.println("Choose your item to sell! (Enter in ID or -1 if you do not want to pick an item)");
				picked = picking.nextInt();
				if (picked != -1) {
					Item item = thisGame.getItem(picked-1);
					sale.sell(item);				
				}
			} while (picked != -1);
		}

		
	}
	
	private static void buy(String type) {
		Purchase object = new Purchase(type, market,thisGame);
		object.displayOptions();
		Scanner picking = new Scanner(System.in);
		if (type == "ATHLETE"){
			String[] positions = new String[] {"SEEKER", "KEEPER", "BEATER", "BEATER", "CHASER", "CHASER", "CHASER"};
			for (int i = 0; i < 7; i++) {
				System.out.println("Choose your "+positions[i]+"! (Enter in ID or -1 if you do not want to pick a player)");
				int pickedID = -1;
				try {
			    	pickedID = picking.nextInt();
			    }
			    catch (Exception e) {
			    	System.out.println(e);
			    
			    }
				if (pickedID != -1) {
					Athlete athlete = market.getAthlete(pickedID-1);
					object.buy(athlete, positions[i]);			
				}
			}
			int reserve;
			do  {
				System.out.println("Choose a reserve! (Enter in ID or -1 if you do not want to pick a reserve)");
				reserve = picking.nextInt();
				if (reserve != -1) {
					Athlete athlete = market.getAthlete(reserve-1);
					object.buy(athlete, "RESERVE");
				}
			} while (reserve != -1);
			
			
		}
		else {
			int picked;
			do  {
				System.out.println("Choose your item! (Enter in ID or -1 if you do not want to pick an item)");
				picked = picking.nextInt();
				if (picked != -1) {
					object.buy(market.getItem(picked-1));	
				}
			} while (picked != -1);
		}
	}

	
	private static void goToMarket() {
		System.out.println("Welcome to the market");
		Scanner todo = new Scanner(System.in);
		System.out.println("What would you like to do? (Enter in number)");
		System.out.println("1 Buy Athletes");
		System.out.println("2 Buy Items");
		System.out.println("3 Sell Athletes");
		System.out.println("4 Sell Items");
		System.out.println("5 Go to Home");
		int nextStep = todo.nextInt();
		if (nextStep == 1) {
			buy("ATHLETE");
		}
		else if (nextStep == 2) {
			buy("ITEM");
		}
		else if (nextStep == 3) {
			sell("ATHLETE");
		}
		else if (nextStep == 4) {
			sell("ITEM");
		}
	}
	
	
	
	private static void viewGame() {
		System.out.println("Welcome to the Club Room!");
		System.out.println("Team Name: "+thisGame.getTeamName());
		System.out.println("Balance: "+thisGame.getBalance());
		System.out.println("Weeks Remaining in Season: "+thisGame.getWeeks());
		System.out.println();
		System.out.println("Your Team: ");
		thisGame.displayTeam();	    
	    System.out.println("Your Items: ");
	    thisGame.displayItems();
	    
	    //add in swapping
	    
		
	}
	
	private static void byeWeek() {
		// add in special training
		thisGame.teamStaminaRefill();
	}
	

	
	
	public static boolean chooseOpTeam() throws IncorrectInput {
		OppositionTeam team1 = new OppositionTeam(market);
		OppositionTeam team2 = new OppositionTeam(market);
		OppositionTeam team3 = new OppositionTeam(market);
		
		Scanner chosingOpposition = new Scanner(System.in);
		
		System.out.println("Choose your opponent: (enter in number)");
		System.out.println("1 team 1");
		System.out.println("2 team 2");
		System.out.println("3 team 3");
		System.out.println("4 OR Take a BYE"); 
		
		int opTeamSelect = 4;
		
		
		try {
			opTeamSelect = chosingOpposition.nextInt();
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		chosingOpposition.close();
		boolean cannotPlay = false;
	    if (thisGame.getTeam().size() < 7){
	    	cannotPlay = true;
	    }
	    if (cannotPlay || opTeamSelect == 4) {
	    	///add in check if game needs to end due to low balance
	    	byeWeek();
	    	return false;
	    }
    	if (opTeamSelect == 1) {
    		thisMatch = new Match(thisGame, team1);	
    	}
    	else if (opTeamSelect == 2){
    		thisMatch = new Match(thisGame, team2);
    	}
    	else {
    		thisMatch = new Match(thisGame, team3);
    	}	
    	return true;	

	}
		
	
	public static void main(String[] args) throws IncorrectInput {
		setUp();
		Scanner input = new Scanner(System.in);
		
	    System.out.println("Enter Team Name:");
	    String name = input.nextLine();
	    System.out.println("Enter duration of game (weeks): ");
	    int weeks = 0;
	    try {
	    	weeks = input.nextInt();
	    }
	    catch (Exception e) {
	    	System.out.println(e);
	    	System.exit(0);
	    }
	    thisGame = new GameEnvironment(name, weeks);
	    
	    
	    System.out.println("Enter Diffuculty (must be 1 or 2):");
	    int difficulty = input.nextInt();
	    String x = input.nextLine();
	    if (difficulty < 1 || difficulty > 2) {
	    	input.close();
	    	throw new IncorrectInput("You did not enter a valid difficulty value");
	    }
	    thisGame.setDifficulty(difficulty);	    
	    System.out.println("It's Time To Make Your Team!");
	    buy("ATHLETE");
	   
	    System.out.println("Let's Play!");


	    while (thisGame.getWeeks() > 0) {
	    	Scanner loopInput = new Scanner(System.in);
	    	System.out.println("What would you like to do? (Enter in number)");
	    	System.out.println("1 View Club");
			System.out.println("2 Go To Market" );
			System.out.println("3 Play Game");	
	    	int goTo = loopInput.nextInt();
	    	
	    	if (goTo == 1) {
	    		viewGame();
	    		
	    	}
	    	else if (goTo == 2) {
	    		goToMarket();

	    	}
	    	else if (goTo == 3){
	    		thisGame.reduceWeek();
	    		chooseOpTeam();
	    		boolean playedGame = chooseOpTeam();
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
				if (eventOccurs < 50*thisGame.getDifficulty()) {
					RandomEvent event = new RandomEvent(thisGame);
				}	
	    	}
	    }

	    
	    System.out.println("Your Final Status!!!");
	    viewGame();
	    

	}

}
