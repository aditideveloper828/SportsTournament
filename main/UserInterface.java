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
public final class UserInterface{
	private static PurchasableManager market = new PurchasableManager();
	private static GameEnvironment thisGame;
	private static Match thisMatch;
	private static InitiateMatchScreen initiateMatch;
	private static Scanner userInput = new Scanner(System.in);
	private static int selectedSeasonDuration;
	private static String[] positions = new String[] {"SEEKER", "KEEPER", "BEATER", "CHASER", "RESERVE"};
	
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
	
	private static void initializeTeam(){
		Purchase object = new Purchase("ATHLETE", market, thisGame);
		System.out.println("Do not worry about contract prices as balance will be reset to original before starting the game");
		object.displayOptions(true);
		String[] positions = new String[] {"SEEKER", "KEEPER", "BEATER", "BEATER", "CHASER", "CHASER", "CHASER"};
		for (int i = 0; i < 7; i++) {
			System.out.println("Choose your "+positions[i]+"! (Enter in ID to pick a player)");
			int pickedID = -1;
			try {
		    	pickedID = userInput.nextInt();
		    }
		    catch (Exception e) {
		    	System.out.println(e);
		    }
			if (pickedID != -1) {
				Athlete athlete = market.getAthlete(pickedID-1);
				object.buy(athlete, positions[i], "Default");
			}
		}
		thisGame.resetBalance();
		
	}
	
	
	
	private static void buy(String type) {
		//limiting the position of athlete can be done in gui
		//change nickname of athlete <----need input box for this
		Purchase object = new Purchase(type, market,thisGame);
		object.displayOptions(false);
		if (type == "ATHLETE"){
			System.out.println("These are the positions that an athlete can be assigned:");
			for (int i = 0; i < 5; i++) {
				System.out.println((i+1)+" "+positions[i]);
			}
			int pickedAthlete;
			int position;
			do  {
				System.out.println("Choose an athlete and then the position you want to assign them! (Enter in ID and number of position OR -1 twice if you want to go to home)");
				pickedAthlete = userInput.nextInt();
				position = userInput.nextInt();
				if (pickedAthlete != -1 && position != -1) {
					Athlete athlete = market.getAthlete(pickedAthlete-1);
					object.buy(athlete, positions[position-1], "Default");
				}
			} while (pickedAthlete != -1 && position != -1);
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
	    
	    //and using item <--- do not have to change position of athletes in team)
	    System.out.println("Would you like to: (Enter in number or -1 to go to home)");
	    System.out.println("1 Swap the position of an active team member and a reserve?");
	    System.out.println("2 Use an item for an athlete");
	    int choice = userInput.nextInt();
	    if (choice != -1) {
	    	if (choice == 1) {
	    		thisGame.displayTeam();
	    		System.out.println("Enter in the IDs of the active member and the reserve");
	    		int activeMemberID = userInput.nextInt();
	    		int reserveMemberID = userInput.nextInt();
	    		Athlete activeMember = thisGame.getTeamMember(activeMemberID-1);
	    		Athlete reserveMember = thisGame.getReserve(reserveMemberID-1);
	    		thisGame.swap(activeMember, reserveMember);
	    	}
	    	else {
	    		thisGame.displayTeam();
	    		thisGame.displayItems();
	    		System.out.println("Enter in the ID of the item you want to use");
	    		int itemToUse = userInput.nextInt();
	    		System.out.println("Enter 1 if you want use the item for an active member and 2 for a reserve");
				int athleteType = userInput.nextInt();
				System.out.println("Enter in the ID of the athlete");
				int athleteID = userInput.nextInt();
				thisGame.useItem(itemToUse-1, athleteType, athleteID-1);	    		
	    	}
	    }
	    
	    
	    
	    
	    
		
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
	

	
	
	public static boolean chooseOpTeam() throws CannotPlay{
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
	    if (insufficientPlayers && thisGame.getReserveSize() == 0) {
	    	if (market.minimumContractPrice() > thisGame.getBalance()) {
	    		throw new CannotPlay("You cannot buy any more players", thisGame, selectedSeasonDuration);
	    	}
    		
    	}
	    
	    if (insufficientPlayers || opTeamSelect == 4) {
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
		
	
	public static void main(String[] args) throws IncorrectInput, CannotPlay {
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
	    ///done till this part
	    initializeTeam();
	   
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
	    System.out.println("Team Name: "+thisGame.getTeamName());
	    System.out.println("Selected Season Duration: "+selectedSeasonDuration);
		System.out.println("Final Balance: "+thisGame.getBalance());
		System.out.println("Total Points: "+thisGame.getPoints());
	    
	    userInput.close();
	}
}
