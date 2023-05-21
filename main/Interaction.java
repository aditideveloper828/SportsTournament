/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Hashtable;


/**
 * @author Aditi Sharma
 *
 */
public class Interaction {
	private PurchasableManager market;
	private GameEnvironment game;
	private Match match;
	private int selectedSeasonDuration;	
	private String[] POSITIONS = new String[] {"SEEKER", "KEEPER", "BEATER", "CHASER"};
	
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
	//not fixed
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
		//also includes bye week functionality
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
	}
	
	
	
	
	
	
	

}
