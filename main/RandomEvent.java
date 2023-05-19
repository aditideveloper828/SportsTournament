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
		
	private Athlete selectAthlete() {
		Random randIdx = new Random();
		athleteIdx = randIdx.nextInt(event.getTeam().size());
		return event.getTeamMember(athleteIdx);
	}
	
	public void statIncrease() {
		Athlete randTeamMember = selectAthlete();
		System.out.println("Exciting News!!" + randTeamMember.getName() + " has had a Stat increase!");
		randTeamMember.statIncrease();
		
	}
	
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
	
	public void newAthlete() {
		Random randJoin = new Random();
		int joiningProb = randJoin.nextInt(100); 
		int barrier = 25 * event.getReserveSize();
		if (joiningProb > barrier) {
			Athlete randPlayer = event.getMarket().getRandAthlete();
			randPlayer.setPosition("RESERVE");
			event.addReserve(randPlayer);
			System.out.println(randPlayer.getName() + " has randomly joined your team! \n They are currently in your reserves");
		}
			
	}
	
}
