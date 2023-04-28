package main;

import java.util.*;

public class PairFight {
	
	private int oppositionRating;
	private Athlete player;
	
	public PairFight(Athlete athlete) {
		player = athlete;
	}
	
	public int createOppositionRating(GameEnvironment game) {
		Random rand = new Random();
		if (game.getDifficulty() == 2) {
			// generates a random integer in between 4 and 10 if the difficulty is hard
			return oppositionRating = (int)Math.floor(Math.random() * (10 - 4 + 1) + 4);
		} else {
			// generates a random integer in between 0 and 6 (inclusive) if the difficulty is easy
			return oppositionRating = rand.nextInt(7);
		}
	}
	
	public void playOffence(GameEnvironment game) {
		if (player.getPosition() == "CHASER" || player.getPosition() == "SEEKER") {
			if (player.getOffence() - createOppositionRating(game) >=0) {
				Match.fightWon();
			}
		}
	}
	
	public void playDefence(GameEnvironment game) {
		if (player.getPosition() == "BEATER") {
			if (player.getDefence() - createOppositionRating(game) >=0) {
				Match.fightWon();
			}
		}
	}
}
