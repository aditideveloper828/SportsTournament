package main;

import java.util.*;

/**
 * Represents a random event that can occur in the game.
 * It can result in a stat increase for a team member, a team member quitting, or a new athlete joining the team.
 */
public class RandomEvent {
	//change so chances of new athlete and athlete quits are low and are affected by current status.
	
	private int athleteIdx;
	private GameEnvironment event;
	
	/**
     * Creates a random event in the game.
     *
     * @param game the game environment
     */
	public RandomEvent(GameEnvironment game) {
		event = game;
		
		int methodNum;
		Random randInt = new Random();
		methodNum = randInt.nextInt(100);
		
		if (methodNum < 60) {
			statIncrease();
		} 
		
		else if (methodNum < 80) {
			randomQuit();
		}
		else {
			newAthlete();
		}
	}
	
	/**
	 * Selects a random Athlete from the team.
	 *
	 * @return The selected Athlete.
	 */
	private Athlete selectAthlete() {
		Random randIdx = new Random();
		athleteIdx = randIdx.nextInt(event.getTeam().size());
		return event.getTeamMember(athleteIdx);
	}
	
	/**
     * Increases the offence and defence ratings of a randomly selected team member.
     */
	public void statIncrease() {
		Athlete randTeamMember = selectAthlete();
		System.out.println("Exciting News!!" + randTeamMember.getName() + " has had a Stat increase!");
		randTeamMember.statIncrease();
	}
	
	/**
     * Simulates a team member randomly quitting the team.
     * The probability of quitting depends on various factors such as injury status.
     */
	public void randomQuit() {
		Random randQuit = new Random();
		int quittingProb = randQuit.nextInt(100);
		Athlete randAthlete = selectAthlete();
		int barrier = 50;
		if (randAthlete.injured()) {
			barrier /= 2;
		}
		if (quittingProb > barrier) {
			event.removeTeamMember(randAthlete);
			System.out.println(randAthlete.getName() + " has quit your team! \n Please make sure you have 6 active players before you play another match");
		}
	}
	
	/**
     * Simulates a new athlete randomly joining the team.
     * The probability of joining depends on various factors such as the size of the reserve team.
     */
	public void newAthlete() {
		Random randJoin = new Random();
		int joiningProb = randJoin.nextInt(100); 
		int barrier = 20 * event.getReserveSize();
		if (joiningProb > barrier) {
			Athlete randPlayer = event.getMarket().getRandAthlete();
			randPlayer.setPosition("RESERVE");
			event.addReserve(randPlayer);
			System.out.println(randPlayer.getName() + " has randomly joined your team! \n They are currently in your reserves");
		}
	}
}
