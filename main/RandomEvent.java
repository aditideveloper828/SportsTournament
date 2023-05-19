package main;

import java.util.*;

public class RandomEvent {
	//change so chances of new athlete and athlete quits are low and are affected by current status.
	
	private int athleteIdx;
	private GameEnvironment event;
	private ArrayList<Athlete> randPlayers;
	
	public RandomEvent(GameEnvironment game, PurchasableManager market) {
		event = game;
		randPlayers = market.getAllAthletes();
		
		int methodNum;
		Random randInt = new Random();
		methodNum = randInt.nextInt(3);
		
		if (methodNum == 0) {
			statIncrease();
		} 
		else if (methodNum == 1) {
			randomQuit();
		}
		else {
			newAthlete();
		}
	}
	
// create a method to pull from the freeAthletes database for random new players
	
	private Athlete selectAthlete() {
		//why only picking from the first 7 athletes???????????????
		Random randIdx = new Random();
		athleteIdx = randIdx.nextInt(event.getTeam().size());
		return event.getTeam().get(athleteIdx);
	}
	
	public void statIncrease() {
		System.out.println("Exciting News!!" + selectAthlete().getName() + " has had a Stat increase!");
		selectAthlete().statIncrease();
		
	}
	
	public void randomQuit() {
		event.removeTeamMember(selectAthlete());
		System.out.println(selectAthlete().getName() + " has quit your team! \n Please make sure you have 6 active players before you play another match");
	}
	
	public void newAthlete() {
		// creating a potential random event of an athlete being added to the reserves
		if (randPlayers.size() > 0 ) {
			Athlete randPlayer = randPlayers.get(0);
			randPlayer.setPosition("RESERVE");
			event.addReserve(randPlayer);
			System.out.println(randPlayer.getName() + " has randomly joined your team! \n They are currently in your reserves");
			randPlayers.remove(0);
		}
	}
	
}
