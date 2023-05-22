/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


/**
 * Represents the interaction between the user and the game environment.
 * Manages the game flow, team management, purchasing, and playing matches.
 * Provides methods for setting up the game, initializing the team, retrieving options, playing matches, and more.
 * Also manages game balance, weeks, random events, and opposition team names.
 *
 */
public class Interaction {
	private PurchasableManager market;
	private GameEnvironment game;
	private Match match;
	private int selectedSeasonDuration;	
	private String resultMessage;
	private String randomEventMessage = "";
	private boolean endGame = false;
	private boolean takeBye = false;
	private String[] POSITIONS = new String[] {"SEEKER", "KEEPER", "BEATER", "CHASER"};
	public ArrayList<String> opTeamNames= new ArrayList<String>();
	public String opTeamName;
	
	/**
     * Constructs a new Interaction object.
     * Initializes the PurchasableManager.
     */
	public Interaction() {
		market = new PurchasableManager();
	}
	
	/**
     * Sets up the game environment by loading athlete and item data from files.
     */
	public void setUp() {
		//change this method to remove duplicate code
		FileRead athleteFile = new FileRead("AthleteMarket");
		ArrayList<String> athleteProfiles = athleteFile.getData();
		for (int i = 1; i < athleteProfiles.size(); i++) {
			String[] characterData = athleteProfiles.get(i).split(";",0);
			int [] stats = new int[5];
			for (int j = 0; j < 5; j++){
				stats[j] = Integer.parseInt(characterData[j+2]);
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
	
	/**
     * Checks if the game should end.
     *
     * @return true if the game should end, false otherwise.
     */
	public boolean shouldEndGame() {
		return endGame;
	}
	
	/**
     * Checks if the user's team should take a bye.
     *
     * @return true if the team should take a bye, false otherwise.
     */
	public boolean shouldTakeBye() {
		return takeBye;
	}
	
	/**
     * Sets up the game environment with the specified name, duration, and difficulty.
     * Calls the setUp() method and initializes the game environment.
     * 
     * @param name       The name of the game environment.
     * @param duration   The duration of the game season.
     * @param difficulty The difficulty level of the game.
     */
	public void setUp(String name, int duration, int difficulty) {
		this.setUp();
		selectedSeasonDuration = duration;
		game = new GameEnvironment(name, duration);
		game.setDifficulty(difficulty);
	}
	
	/**
     * Initializes the team with the specified list of athletes.
     * Uses the Purchase class to buy athletes and assigns them to the team.
     * Resets the game balance after initializing the team.
     * 
     * @param athletes The list of athletes to initialize the team with.
     */
	public void initializeTeam(ArrayList<Athlete> athletes) {
		Purchase initialize = new Purchase("ATHLETE", market, game);
		for (int i = 0; i < 8; i++) {
			initialize.buy(athletes.get(i), athletes.get(i).getPosition());
		}
		game.resetBalance();
	}
	
	/**
     * Returns the PurchasableManager.
     *
     * @return The PurchasableManager object.
     */
	public PurchasableManager getMarket() {
		return market;
	}
	
	/**
     * Returns the result message of the last match.
     *
     * @return The result message.
     */
	public String getResultMessage() {
		return resultMessage;
	}
	
	/**
     * Returns the random event message.
     *
     * @return The random event message.
     */
	public String getRandomEventMessage() {
		return randomEventMessage;
	}
	 
	/**
     * Returns the selected season duration.
     * 
     * @return The selected season duration
     */
	public int getSeasonDuration() {
		return selectedSeasonDuration;
	}
	
	/**
     * Retrieves a list of athlete options for the team initialization.
     * Returns a specified number of athlete options based on whether it is the initial team setup.
     * 
     * @param initializing A boolean value indicating whether it is the initial team setup.
     * @return The list of athlete options.
     */
	public ArrayList<Athlete> getAthleteOptions(boolean initializing) {
		int toGet = 5;
		if (initializing) {
			toGet = 14;
		}
		return market.getSomeAthletes(toGet);
	}
	
	/**
     * Retrieves a list of item options available in the market.
     * 
     * @return The list of item options.
     */
	public ArrayList<Item> getItemOptions(){
		return market.getAllItems();
	}
	
	/**
     * Retrieves the full team, including team members and reserves.
     * 
     * @return The full team.
     */
	public ArrayList<Athlete> getFullTeam(){
		ArrayList<Athlete> team = new ArrayList<Athlete>(game.getTeam());
		ArrayList<Athlete> reserves = new ArrayList<Athlete>(game.getReserves());
		for (int i = 0; i < reserves.size(); i++){
			team.add(reserves.get(i));
		}
		return team;
	}
	
	/**
     * Retrieves the list of bought items by the team.
     * 
     * @return The list of bought items.
     */
	public ArrayList<Item> getBoughtItems(){
		return game.getItems();
	}
	
	/**
     * Retrieves the game environment object.
     * 
     * @return The game environment object.
     */
	public GameEnvironment getGame() {
		return game;
	}
	
	/**
     * Generates a list of random opposition team names.
     * 
     * @return The list of random opposition team names.
     */
	public ArrayList<String> getOpTeamName() {
		opTeamNames.add("Stinky Soldiers");
		opTeamNames.add("Blue Bottles");
		opTeamNames.add("Rabbit Runners");
		opTeamNames.add("Wing Warriors");
		opTeamNames.add("Raging Rangers");
		opTeamNames.add("Potter Squatters");
		opTeamNames.add("Snape Shapes");
		opTeamNames.add("Broomful Bunnies");
		opTeamNames.add("Arranged Arrows");
		opTeamNames.add("Smiley Smokers");
		opTeamNames.add("Beautiful Bubbles");
		opTeamNames.add("Lacrosse Lovers");
		opTeamNames.add("Coffee Addicts");
		opTeamNames.add("Neat Freaks");
		opTeamNames.add("Whiz Kids");
		opTeamNames.add("Geek Squad");
		opTeamNames.add("College Dropouts");
		opTeamNames.add("Fire Extinguishers");
		opTeamNames.add("Trailblazers");
		opTeamNames.add("Lethal Weapons");
		
		Set<Integer> randTeamIndex = new HashSet<Integer>();
		while (randTeamIndex.size() < 3) {
			Random randInt = new Random();
			randTeamIndex.add(randInt.nextInt(opTeamNames.size())); 
		}
		ArrayList<String> returnNames = new ArrayList<String>();
		Iterator<Integer> itr = randTeamIndex.iterator();
		int i = 0;
		while(itr.hasNext()){
			returnNames.add(opTeamNames.get(itr.next()));
			i++;
		}
		return returnNames;
	}
	
	/**
     * Retrieves the remaining weeks in the game season.
     * 
     * @return The remaining weeks.
     */
	public int remainingWeeks() {
		return game.getWeeks();
	}
	
	/**
     * Buys an athlete and assigns them to the specified position in the game.
     * Checks if the balance is sufficient and if the position is already filled.
     * 
     * @param athlete   The athlete to buy.
     * @param position  The position to assign the athlete to.
     * @return          A message indicating the success or failure of the purchase.
     */
	public String buy(Athlete athlete, String position) {
		if (athlete.getContractPrice() <= game.getBalance()){
			Purchase buying = new Purchase("ATHLETE", market, game);
			switch(position) {
			case "SEEKER":
				long seekers = game.getTeam().stream().filter(x -> x.getPosition() == "SEEKER" ).count();
				if (seekers < 1) {
					buying.buy(athlete, position);
					return "The athlete has been bought";
				}
				break;
				
			case "BEATER":
				long beaters = game.getTeam().stream().filter(x -> x.getPosition() == "BEATER" ).count();
				if (beaters < 2) {
					buying.buy(athlete, position);
					return "The athlete has been bought";
				}
				break;
			case "CHASER":
				long chasers = game.getTeam().stream().filter(x -> x.getPosition() == "CHASER" ).count();
				if (chasers < 3) {
					buying.buy(athlete, position);
					return "The athlete has been bought";
				}
				break;
			case "KEEPER":
				long keepers = game.getTeam().stream().filter(x -> x.getPosition() == "KEEPER" ).count();
				if (keepers < 1) {
					buying.buy(athlete, position);
					return "The athlete has been bought";
				}
				break;
			case "RESERVE":
				if (game.getReserveSize() < 5) {
					buying.buy(athlete, position);
					return "The athlete has been bought";
				}
				break;
			}
			return "You have too many athletes in this position!";
			
		}
		else{
			return "Your balance is too low to buy this athlete.";
		}
		
	}
	
	/**
     * Sells the specified object based on the object ID, type, and position.
     * Uses the Purchase class to sell items or athletes from the game environment.
     * 
     * @param objectID  The ID of the object to be sold.
     * @param type      The type of the object (1 for item, 2 for athlete).
     * @param position  The position of the athlete to be sold.
     */
	public void sell(int objectID, int type, String position) {
		//type 1 is item, 2 is athlete
		if (type == 1) {
			Purchase selling = new Purchase("ITEM", market, game);
			selling.sell(game.getItem(objectID));
		}
		else {
			Purchase selling = new Purchase("ATHLETE", market, game);
			if (position == "RESERVE"){
				objectID -= game.getTeamSize();
				selling.sell(game.getReserve(objectID));
			}
			else {
				selling.sell(game.getTeamMember(objectID));
			}
		}
	}
	
	/**
	 * Buys an item from the market and adds it to the game.
	 * Checks if the player's balance is sufficient to buy the item.
	 * 
	 * @param item The item to be bought.
	 * @return A message indicating the success or failure of the purchase.
	 */
	public String buy(Item item) {
		if (item.getContractPrice() <= game.getBalance()) {
			Purchase buying = new Purchase("ITEM", market, game);
			buying.buy(item);
			return "Item bought!";
		}
		else {
			return "Your balance is too low to buy this item.";
		}
		
	}
	
	/**
     * Fills the specified position with the given reserve athlete.
     * Determines the required numbers for each position and checks if the position is not already filled.
     * Removes the reserve athlete, assigns the position, and adds the athlete to the team.
     * 
     * @param reserve The reserve athlete to be assigned to a position.
     */
	public void fillPosition(Athlete reserve) {
		long[] count = new long[4];
		long[] requiredNums = new long[] {1, 1, 2, 3};
		for (int i = 0; i < 4; i++) {
			String position = POSITIONS[i];
			count[i] =  game.getTeam().stream().filter(x -> x.getPosition() == position).count();
		}
		int i = 0;
		boolean notUsed = true;
		while (i < 4 && notUsed) {
			i += 1;
			if (count[i] < requiredNums[i]) {
				game.removeReserve(reserve);
				reserve.setPosition(POSITIONS[i]);
				game.addTeamMember(reserve);
				notUsed = false;
			}
		}
	}
	
	/**
     * Plays a game against the specified opposition team.
     * Manages game logic, including checking for insufficient players, injuries, and match results.
     * Handles random events during gameplay.
     * 
     * @param opTeam The opposition team to play against.
     */
	public void playGame(OppositionTeam opTeam) {
		randomEventMessage = "";
		boolean insufficientPlayers = false;
	    long playersInjured = game.getTeam().stream().filter(x -> x.injured() == true).count();
	    playersInjured += game.getReserves().stream().filter(x -> x.injured() == true).count();
	    if (game.getTeamSize() < 7){
	    	insufficientPlayers = true;
	    }
	    
	    if (insufficientPlayers && game.getReserveSize() == 0) {
	    	if (market.minimumContractPrice() > game.getBalance()) {
	    		endGame = true;
	    		resultMessage = "You have insufficient players and balance to continue playing";
	    	}
    	}
	    else if (insufficientPlayers){
	    	takeBye = true;
	    	resultMessage = "Your team has insufficient members, you must take a bye this week";
	    }
	    else if (playersInjured == game.getReserveSize() + game.getTeamSize()) {
	    	takeBye = true;
	    	resultMessage = "All your players are injured. You must take a bye to heal";
	    }
	    else {
	    	game.reduceWeek();
	    	match = new Match(game, opTeam);
	    	boolean matchResult = match.matchWon();
	    	if (matchResult == true) {
	    		resultMessage = "Congratulations! You won this weeks's match!";
	    		game.increaseBalance((10*match.getTeamTotal())/game.getDifficulty()); 
	    		game.increasePoints(10*match.getTeamTotal()/game.getDifficulty());
	    	}
	    	else {
	    		resultMessage = "You lost. Better luck next time!";
	    	}
	    	Random randomEvent = new Random();
	 		int eventOccurs = randomEvent.nextInt(100);
	 		if (eventOccurs < 100/(game.getDifficulty()*10)) {
	 			RandomEvent event = new RandomEvent(game, market);
	 			randomEventMessage = event.getEventMessage();
	 		}
	    }
	}
	
	/**
	 * Performs special training on an athlete at the specified index and position.
	 * Refills the team's stamina, increases the athlete's stats based on the difficulty level,
	 * and reduces the week. Checks if the week count reaches zero to end the game.
	 * 
	 * @param index    The index of the athlete.
	 * @param position The position of the athlete.
	 */
	public void specialTraining(int index, String position) {
		takeBye = false;
		game.teamStaminaRefill();
		int repeat = 4/game.getDifficulty();
		if (position != "RESERVE") {
			for (int i = 0; i < repeat; i++) {
				game.getTeamMember((index)).statIncrease();
			}
		}
		else {
			for (int i = 0; i < repeat; i++) {
				game.getReserve(index).statIncrease();
			}
		}
		game.reduceWeek();
		if (game.getWeeks() == 0) {
			endGame = true;
		}
	}

}
