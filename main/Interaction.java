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
 * @author Aditi Sharma
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
	
	public Interaction() {
		market = new PurchasableManager();
	}
	
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
	
	public PurchasableManager getMarket() {
		return market;
	}
	
	public boolean shouldEndGame() {
		return endGame;
	}
	
	public boolean shouldTakeBye() {
		return takeBye;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}
	
	public String getRandomEventMessage() {
		return randomEventMessage;
	}
	
	public int getSeasonDuration() {
		return selectedSeasonDuration;
	}
	
	public void setUp(String name, int duration, int difficulty) {
		this.setUp();
		selectedSeasonDuration = duration;
		game = new GameEnvironment(name, duration);
		game.setDifficulty(difficulty);
	}
	
	public void initializeTeam(ArrayList<Athlete> athletes) {
		Purchase initialize = new Purchase("ATHLETE", market, game);
		for (int i = 0; i < 8; i++) {
			initialize.buy(athletes.get(i), athletes.get(i).getPosition());
		}
		game.resetBalance();
	}
	
	public ArrayList<Athlete> getAthleteOptions(boolean initializing) {
		int toGet = 5;
		if (initializing) {
			toGet = 14;
		}
		return market.getSomeAthletes(toGet);
	}
	
	public ArrayList<Item> getItemOptions(){
		return market.getAllItems();
	}
	
	public int remainingWeeks() {
		return game.getWeeks();
	}
	
	public ArrayList<Athlete> getFullTeam(){
		ArrayList<Athlete> team = new ArrayList<Athlete>(game.getTeam());
		ArrayList<Athlete> reserves = new ArrayList<Athlete>(game.getReserves());
		for (int i = 0; i < reserves.size(); i++){
			team.add(reserves.get(i));
		}
		return team;
	}
	
	public ArrayList<Item> getBoughtItems(){
		return game.getItems();
	}
	
	public GameEnvironment getGame() {
		return game;
	}
	
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
