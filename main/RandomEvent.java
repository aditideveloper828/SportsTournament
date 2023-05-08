package main;

import java.util.*;

public class RandomEvent {
	
	private int athleteIdx;
	private GameEnvironment event;
	private ArrayList<Athlete> randPlayers;
	
	public RandomEvent(GameEnvironment game) {
		event = game;
		
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
	
	public void randomArray() {
		//randPlayers.add(new Athlete("name0",8,5,100));
		//randPlayers.add(new Athlete("name1",5,6,100));
		//randPlayers.add(new Athlete("name2",9,2,100));
		//randPlayers.add(new Athlete("name3",1,8,100));
		//randPlayers.add(new Athlete("name4",4,5,100));
		//randPlayers.add(new Athlete("name5",3,9,100));
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
		event.removeTeamMember(selectAthlete());
		System.out.println(selectAthlete().getName() + " has quit your team! \n Please make sure you have 6 active players before you play another match");
	}
	
	public void newAthlete() {
		// creating a potential random event of an athlete being added to the reserves
		if (randPlayers.size() > 0) {
			event.addReserve(randPlayers.get(0));
			System.out.println(randPlayers.get(0) + " has randomly joined your team! \n They are currently in your reserves");
			randPlayers.remove(0);
		}
	}
	
}
