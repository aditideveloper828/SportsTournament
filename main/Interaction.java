/**
 * 
 */
package main;

import java.util.ArrayList;


/**
 * @author Aditi
 *
 */
public class Interaction {
	private PurchasableManager market;
	private GameEnvironment game;
	private Match match;
	private int selectedSeasonDuration;
	private String[] positions = new String[] {"SEEKER", "KEEPER", "BEATER", "CHASER", "RESERVE"};
	
	
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
		ArrayList<Athlete> team = game.getTeam();
		team.addAll(game.getReserves());
		return team;
	}
	
	public ArrayList<Item> getBoughtItems(){
		return game.getItems();
	}
	
	public GameEnvironment getGame() {
		return game;
	}
	
	public void sell(int objectID, int type) {
		
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
