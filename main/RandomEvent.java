package main;

import java.util.*;

public class RandomEvent {
	
	private int athleteIdx;
	private GameEnvironment event;
	private double quitProb;
	private int athleteQuit;
	
	public RandomEvent(GameEnvironment game) {
		event = game;
	}
	
	private Athlete selectAthlete() {
		Random randIdx = new Random();
		athleteIdx = randIdx.nextInt(7);
		return event.getTeam().get(athleteIdx);
	}
	
	public void statIncrease() {
		System.out.println("Exciting News!!" + selectAthlete().getName() + " has had a Stat increase!");
		selectAthlete().statIncrease();
	}
	
	public void randomQuit() {
		quitProb = 100*(0.1 * selectAthlete().getRandomQuitProb());
		Random randQuit = new Random();
		athleteQuit = randQuit.nextInt(100);
		if (athleteQuit <= quitProb) {
			System.out.println(selectAthlete().getName() + "has quit your team! \n You must now go to the Market to buy a new player.");
			event.removeTeamMember(selectAthlete());
		}
	}
	
//	public newAthlete() {
//		
//	}
}
