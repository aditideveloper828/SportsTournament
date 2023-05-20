package main;
/**
 * 
 */


/**
 * @author Aditi Sharma
 *
 */
import java.util.*;

public class GameEnvironment {
	private static PurchasableManager market = new PurchasableManager();
	private ArrayList<Athlete> team;
	private ArrayList<Athlete> reserves;
	private ArrayList<Item> items;
	private int difficulty;
	private String teamName;
	private int weeks;
	private int balance = 1000;
	private int points = 0;
	private int teamSize = 0;
	private int reserveSize = 0;
	private int itemSize = 0;
	
	//add in throw errors if there are too many members in team or reserves;
	
	public GameEnvironment(String name, int duration) {
		teamName = name;
		weeks = duration;
		team = new ArrayList<Athlete>();
		reserves = new ArrayList<Athlete>();
		items = new ArrayList<Item>();
		
	}
	
	public void setUp() {
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
	
	public void resetBalance() {
		balance = 100;
	}
	
	public PurchasableManager getMarket() {
		return market;
	}
	
	public void addTeamMember(Athlete athlete) {
		team.add(athlete);
		teamSize += 1;
	}
	
	public Item getItem(int id) {
		return items.get(id);
	}
	
	public Athlete getReserve(int id) {
		return reserves.get(id);
	}
	
	public Athlete getTeamMember(int id) {
		return team.get(id);
	}
	
	public void removeTeamMember(Athlete athlete) {
		team.remove(athlete);
		teamSize -= 1;
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		itemSize -= 1;
	}
	
	public void removeReserve(Athlete athlete) {
		reserves.remove(athlete);
		reserveSize -= 1;
	}
	
	public void addReserve(Athlete athlete) {
		reserves.add(athlete);
		reserveSize += 1;
	}
	
	public void increasePoints(int addition) {
		points += addition;
	}
	
	public int getPoints() {
		return points;
		
	}
	
	public int getItemSize(){
		return itemSize;
	}
	
	public int getTeamSize() {
		return teamSize;
	}
	
	public int getReserveSize() {
		return reserveSize;
	}
	
	public void swap(Athlete activeMember, Athlete reserveMember) {
		reserveMember.setPosition(activeMember.getPosition());
		activeMember.setPosition("RESERVE");
		this.addTeamMember(reserveMember);
		this.addReserve(activeMember);
		this.removeTeamMember(activeMember);
		this.removeReserve(reserveMember);
	}
	
	
	
	public void addItem(Item item) {
		items.add(item);
		itemSize += 1;
	}
	
	
	public ArrayList<Athlete> getTeam() {
		return team;
	}
	
	public ArrayList<Athlete> getReserves() {
		return reserves;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public int getWeeks() {
		return weeks;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void reduceWeek() {
		weeks -= 1;
	}
	
	public void teamStaminaRefill() {
		int i;
		for (i=0; i < team.size(); i++) {
			team.get(i).staminaRefill();
		}
		for (i=0; i < reserves.size(); i++) {
			reserves.get(i).staminaRefill();
		}
		
		
	}
	
	public int getBalance() {
		return balance;
		
	}
	
	public void increaseBalance(int increase) {
		balance += increase;
		
	}
	
	public void reduceBalance(int decrease) {
		balance -= decrease;
		
	}

	public void displayTeam() {
		
		System.out.println("Active Members: ");
		for (int i = 0; i < team.size(); i++) {
			System.out.println("ID " + (i+1));
			System.out.println(team.get(i));
		}
		
		System.out.println("Reserve Members: ");
		for (int i = 0; i < reserves.size(); i++){
			System.out.println("ID " + (i+1));
			System.out.println(reserves.get(i));
		}
		
	}
	
	public void useItem(int itemID, int athleteType, int athleteID) {
		Item beingUsed = items.get(itemID);
		this.removeItem(beingUsed);
		if (athleteType == 1) {
			team.get(athleteID).boost(beingUsed);
		}
		else {
			reserves.get(athleteID).boost(beingUsed);
		}
	}
	
	
	public void displayItems() {
		for (int i = 0; i < items.size(); i++) {
			System.out.println("ID " + (i+1));
			System.out.println(items.get(i));
		}
		
	}
	

}
