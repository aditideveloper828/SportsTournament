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
	private static InitiateMatchScreen initiateMatch;
	private static Scanner userInput = new Scanner(System.in);
	private static int selectedSeasonDuration;
	
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
		if (type == "ATHLETE"){
			thisGame.displayTeam();
			int sellType;
			int picked = 0;
			do {
				System.out.println("Enter 1 if you want to sell an active member and 2 if you want to sell a reserve or -1 if you want to go home");
				sellType = userInput.nextInt();
				if (sellType != -1){
					System.out.println("Choose your athlete to sell! (Enter in ID or -1 if you do not want to pick an item)");
					picked = userInput.nextInt();
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
				picked = userInput.nextInt();
				if (picked != -1) {
					Item item = thisGame.getItem(picked-1);
					sale.sell(item);				
				}
			} while (picked != -1);
		}		
	}
	
	private static void buy(String type) {
		//making team had more options while market only has 3-5 options
		//making team should not cost money
		//change nickname of athlete <---fix this when the athlete is drafted back to purchasable
		Purchase object = new Purchase(type, market,thisGame);
		object.displayOptions();
		if (type == "ATHLETE"){
			String[] positions = new String[] {"SEEKER", "KEEPER", "BEATER", "BEATER", "CHASER", "CHASER", "CHASER"};
			for (int i = 0; i < 7; i++) {
				System.out.println("Choose your "+positions[i]+"! (Enter in ID or -1 if you do not want to pick a player)");
				int pickedID = -1;
				try {
			    	pickedID = userInput.nextInt();
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
				reserve = userInput.nextInt();
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
				picked = userInput.nextInt();
				if (picked != -1) {
					object.buy(market.getItem(picked-1));	
				}
			} while (picked != -1);
		}
	}

	
	private static void goToMarket() {
		System.out.println("Welcome to the market");
		System.out.println("What would you like to do? (Enter in number)");
		System.out.println("1 Buy Athletes");
		System.out.println("2 Buy Items");
		System.out.println("3 Sell Athletes");
		System.out.println("4 Sell Items");
		System.out.println("5 Go to Home");
		int nextStep = userInput.nextInt();
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
		System.out.println("Points: "+thisGame.getPoints());
		System.out.println("Weeks Remaining in Season: "+thisGame.getWeeks());
		System.out.println();
		System.out.println("Your Team: ");
		thisGame.displayTeam();	    
	    System.out.println("Your Items: ");
	    thisGame.displayItems();
	    
	    //add in swapping (only have to do swapping and using item <--- do not have to change position of athletes in team)
	    System.out.println("Would you like to: (Enter in number or -1 to go to home)");
	    System.out.println("1 Swap the position of an active team member and a reserve?");
	    System.out.println("2 Use an item for an athlete");
	    
	    
		
	}
	
	private static void byeWeek() {
		thisGame.teamStaminaRefill();
		System.out.println("You can give one of your athletes special training!");
		System.out.println("Here are your athletes!");
		thisGame.displayTeam();
		System.out.println("Enter 1 if you want to train an active member and 2 if you want to train a reserve or -1 if you want to go to home");
		int athleteType = userInput.nextInt();
		if (athleteType != -1) {
			System.out.println("Enter the ID of the athelete you want to train");
			int chosenAthlete = userInput.nextInt();
			if (athleteType == 1) {
				for (int i = 0; i < 3; i++) {
					thisGame.getTeamMember((chosenAthlete-1)).statIncrease();
				}
			}
			else {
				for (int i = 0; i < 3; i++) {
					thisGame.getReserve(chosenAthlete-1).statIncrease();
				}
				
			}
		}
	}
	

	
	
	public static boolean chooseOpTeam() throws IncorrectInput {
		OppositionTeam team1 = new OppositionTeam(market, initiateMatch);
		OppositionTeam team2 = new OppositionTeam(market, initiateMatch);
		OppositionTeam team3 = new OppositionTeam(market, initiateMatch);
		
		
		System.out.println("Choose your opponent: (enter in number)");
		System.out.println("1 team1");
		System.out.println("2 team2");
		System.out.println("3 team3");
		System.out.println("4 OR Take a BYE"); 
		
		int opTeamSelect = 4;
		
		
		try {
			opTeamSelect = userInput.nextInt();
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		boolean insufficientPlayers = false;
	    if (thisGame.getTeamSize() < 7){
	    	insufficientPlayers = true;    	
	    	System.out.println("Your team does not have enough members, you have to take a buy this week");
	    }
	    
	    int playersInjured = 0;
	    for (int i = 0; i < thisGame.getTeamSize(); i++) {
    		if (thisGame.getTeamMember(i).injured()) {
    			playersInjured += 1;
    		}
    	}
	    for (int i = 0; i < thisGame.getReserveSize(); i++) {
    		if (thisGame.getReserve(i).injured()) {
    			playersInjured += 1;
    		}
    	}
	    if (playersInjured == thisGame.getReserveSize() + thisGame.getTeamSize()) {
	    	System.out.println("All of players are injured. You have to take a bye to heal.");
	    }
	    
	    
	    if (insufficientPlayers || opTeamSelect == 4) {
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
    	team1.disposeOpTeam();
    	team2.disposeOpTeam();
    	team3.disposeOpTeam();
    	return true;	

	}
		
	
	public static void main(String[] args) throws IncorrectInput {
		setUp();
		
	    System.out.println("Enter Team Name:");
	    String name = userInput.nextLine();
	    System.out.println("Enter duration of game (weeks): ");
	    try {
	    	selectedSeasonDuration = userInput.nextInt();
	    }
	    catch (Exception e) {
	    	System.out.println(e);
	    	System.exit(0);
	    }
	    thisGame = new GameEnvironment(name, selectedSeasonDuration);
	    
	    
	    System.out.println("Enter Diffuculty (must be 1 or 2):");
	    int difficulty = userInput.nextInt();
	    if (difficulty < 1 || difficulty > 2) {
	    	throw new IncorrectInput("You did not enter a valid difficulty value");
	    }
	    thisGame.setDifficulty(difficulty);	    
	    System.out.println("It's Time To Make Your Team!");
	    buy("ATHLETE");
	   
	    System.out.println("Let's Play!");


	    while (thisGame.getWeeks() > 0) {
	    	System.out.println("What would you like to do? (Enter in number)");
	    	System.out.println("1 View Club");
			System.out.println("2 Go To Market" );
			System.out.println("3 Play Game");	
	    	int goTo = userInput.nextInt();
	    	
	    	if (goTo == 1) {
	    		viewGame();
	    		
	    	}
	    	else if (goTo == 2) {
	    		goToMarket();

	    	}
	    	else if (goTo == 3){
	    		thisGame.reduceWeek();
	    		boolean playedGame = chooseOpTeam();
			    if (playedGame) {
			    	boolean result = thisMatch.matchWon();
			    	if (result) {
			    		System.out.println("Congratulations! You won this weeks's match!");
			    		thisGame.increaseBalance(25*thisMatch.getTeamTotal()/thisGame.getDifficulty()); 
			    		thisGame.increasePoints(10*thisMatch.getTeamTotal()/thisGame.getDifficulty());
			    	}
			    	else {
			    		System.out.println("You lost. Better luck next time!");
			    	}
			    }
	    	}
	    	Random randomEvent = new Random();
			int eventOccurs = randomEvent.nextInt(100);
			if (eventOccurs < 100/(thisGame.getDifficulty()*10)) {
				@SuppressWarnings("unused")
				RandomEvent event = new RandomEvent(thisGame);
			}
	    }

	    
	    System.out.println("Your Final Status!!!");
	    System.out.println("Team Name"+thisGame.getTeamName());
	    System.out.println("Selected Season Duration"+selectedSeasonDuration);
		System.out.println("Final Balance: "+thisGame.getBalance());
		System.out.println("Total Points: "+thisGame.getPoints());
	    
	    userInput.close();
	}
}
