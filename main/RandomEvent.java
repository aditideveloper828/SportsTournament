package main;

import java.util.*;

public class RandomEvent {
	
	private int athleteIdx;
	private Athlete player;
	
	public RandomEvent(Athlete athlete) {
		player = athlete;
	}
	
	private int selectAthlete() {
		Random randIdx = new Random();
		return athleteIdx = randIdx.nextInt(7);
	}
	
	public void statIncrease() {
		System.out.println("Exciting News!!" + player.getName() + " has had a Stat increase!");
		player.statIncrease();
	}
	
	public randomQuit() {
		
	}
	
	public newAthlete() {
		
	}
}
