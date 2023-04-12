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
		
	}
	
	public void addTeamMember(Athlete athlete) {
		team.add(athlete);
	}
	
	public void addReserve(Athlete athlete) {
		reserves.add(athlete);
	}
	
	
	public ArrayList<Athlete> getTeam() {
		return team;
	}
	
	public ArrayList<Athlete> getReserves() {
		return reserves;
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
