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
	private ArrayList<Athlete> team;
	private ArrayList<Athlete> reserves;
	private ArrayList<Item> items;
	private int difficulty;
	private String teamName;
	private int weeks;	
	
	//Change different types of players to team and reserves;
	public GameEnvironment(String name, int difficulty, int duration) {
		teamName = name;
		this.difficulty = difficulty;
		weeks = duration;
		team = new ArrayList<Athlete>();
		reserves = new ArrayList<Athlete>();
		items = new ArrayList<Item>();
		
	}
	
	public void addTeamMember(Athlete athlete) {
		team.add(athlete);
	}
	
	public void removeTeamMember(Athlete athlete) {
		team.remove(athlete);
	}
	
	public void addReserve(Athlete athlete) {
		reserves.add(athlete);
	}
	
	public void addItem(Item item) {
		items.add(item);
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
	
	public int getWeeks() {
		return weeks;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void reduceWeek() {
		weeks -= 1;
	}
	
	

}
