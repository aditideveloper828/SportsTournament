package main;

import java.util.ArrayList;

/**
 * Unused Methods:
 * 
 * public int getItemSize(){
		return itemSize;
	}
 */

/**
 * This class represents the game environment for managing a team, reserves, items, and game progress.
 * 
 * @author Aditi Sharma
 */
public class GameEnvironment {
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
	
	/**
     * Constructs a GameEnvironment object with the specified team name and duration.
     *
     * @param name     the name of the team
     * @param duration the duration of the game in weeks
     */
	public GameEnvironment(String name, int duration) {
		teamName = name;
		weeks = duration;
		team = new ArrayList<Athlete>();
		reserves = new ArrayList<Athlete>();
		items = new ArrayList<Item>();
	}
	
	/**
     * Adds an athlete to the team.
     *
     * @param athlete the athlete to add to the team
     */
	public void addTeamMember(Athlete athlete) {
		team.add(athlete);
		teamSize += 1;
	}
	
	/**
     * Adds an athlete to the reserves.
     *
     * @param athlete the athlete to add to the reserves
     */
	public void addReserve(Athlete athlete) {
		reserves.add(athlete);
		reserveSize += 1;
	}
	
	/**
     * Adds an item to the items list.
     *
     * @param item the item to add
     */
	public void addItem(Item item) {
		items.add(item);
		itemSize += 1;
	}
	
	/**
     * Sets the difficulty level of the game.
     *
     * @param difficulty the difficulty level to set
     */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
     * Returns the item at the specified index.
     *
     * @param id the index of the item
     * @return the item at the specified index
     */
	public Item getItem(int id) {
		return items.get(id);
	}
	
	/**
     * Returns the reserve athlete at the specified index.
     *
     * @param id the index of the reserve athlete
     * @return the reserve athlete at the specified index
     */
	public Athlete getReserve(int id) {
		return reserves.get(id);
	}
	
	/**
     * Returns the team member athlete at the specified index.
     *
     * @param id the index of the team member athlete
     * @return the team member athlete at the specified index
     */
	public Athlete getTeamMember(int id) {
		return team.get(id);
	}
	
	/**
     * Returns the current points.
     *
     * @return the current points
     */
	public int getPoints() {
		return points;
	}
	
	/**
     * Returns the number of team members.
     *
     * @return the number of team members
     */
	public int getTeamSize() {
		return teamSize;
	}
	
	/**
     * Returns the number of reserves.
     *
     * @return the number of reserves
     */
	public int getReserveSize() {
		return reserveSize;
	}
	
	/**
	 * Returns the list of team members.
	 *
	 * @return the list of team members
	 */
	public ArrayList<Athlete> getTeam() {
		return team;
	}
	
	/**
	 * Returns the list of reserve athletes.
	 *
	 * @return the list of reserve athletes
	 */
	public ArrayList<Athlete> getReserves() {
		return reserves;
	}
	
	/**
	 * Returns the list of items.
	 *
	 * @return the list of items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Returns the difficulty level of the game.
	 *
	 * @return the difficulty level
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Returns the number of weeks in the game.
	 *
	 * @return the number of weeks
	 */
	public int getWeeks() {
		return weeks;
	}
	
	/**
	 * Returns the name of the team.
	 *
	 * @return the team name
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/**
	 * Returns the current balance.
	 *
	 * @return the current balance
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Removes the specified team member from the team.
	 *
	 * @param athlete the team member to remove
	 */
	public void removeTeamMember(Athlete athlete) {
		team.remove(athlete);
		teamSize -= 1;
	}
	
	/**
	 * Removes the specified item from the items list.
	 *
	 * @param item the item to remove
	 */
	public void removeItem(Item item) {
		items.remove(item);
		itemSize -= 1;
	}
	
	/**
	 * Removes the specified athlete from the reserves.
	 *
	 * @param athlete the athlete to remove
	 */
	public void removeReserve(Athlete athlete) {
		reserves.remove(athlete);
		reserveSize -= 1;
	}
	
	/**
	 * Resets the user's balance to the initial value of 100.
	 */
	public void resetBalance() {
		balance = 100;
	}
	

	/**
	 * Increases the user's balance by the specified amount.
	 *
	 * @param increase the amount to increase the balance by
	 */
	public void increaseBalance(int increase) {
		balance += increase;
	}
	
	/**
	 * Reduces the balance by the specified amount.
	 *
	 * @param decrease the amount to reduce the balance by
	 */
	public void reduceBalance(int decrease) {
		balance -= decrease;
	}
	
	/**
	 * Increases the points by the specified amount.
	 *
	 * @param addition the amount to increase the points by
	 */
	public void increasePoints(int addition) {
		points += addition;
	}
	
	/**
	 * Reduces the number of weeks by 1.
	 */
	public void reduceWeek() {
		weeks -= 1;
	}
	
	/**
	 * Swaps the active team member with the reserve member, updating their positions.
	 *
	 * @param activeMember  the active team member
	 * @param reserveMember the reserve member
	 */
	public void swap(Athlete activeMember, Athlete reserveMember) {
		reserveMember.setPosition(activeMember.getPosition());
		activeMember.setPosition("RESERVE");
		this.addTeamMember(reserveMember);
		this.addReserve(activeMember);
		this.removeTeamMember(activeMember);
		this.removeReserve(reserveMember);
	}
	
	/**
	 * Refills the stamina of all team members and reserves.
	 */
	public void teamStaminaRefill() {
		int i;
		for (i=0; i < team.size(); i++) {
			team.get(i).staminaRefill();
		}
		for (i=0; i < reserves.size(); i++) {
			reserves.get(i).staminaRefill();
		}
	}

	/**
	 * Displays the active team members and reserve members.
	 */
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
	
	/**
	 * Displays the items.
	 */
	public void displayItems() {
		for (int i = 0; i < items.size(); i++) {
			System.out.println("ID " + (i+1));
			System.out.println(items.get(i));
		}
	}
	
	/**
	 * Uses the specified item on the athlete with the given athleteType and athleteID.
	 *
	 * @param itemID      the ID of the item to use
	 * @param athleteType the type of the athlete (1 for team member, 2 for reserve)
	 * @param athleteID   the ID of the athlete to use the item on
	 */
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
}
