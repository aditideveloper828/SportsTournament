package main;

/**
 * The PairFight class represents a face-off between two athletes in a game.
 * It determines the outcome of the face-off based on the positions and attributes
 * of the athletes involved.
 */

public class PairFight {
	
	private Athlete player;
	private Athlete opPlayer;
	
	/**
	 * Constructs a PairFight object with the given athletes.
	 * 
	 * @param athlete    the player athlete participating in the face-off
	 * @param opAthlete  the opposing athlete participating in the face-off
	 */
	public PairFight(Athlete athlete, Athlete opAthlete) {
		player = athlete;
		opPlayer = opAthlete;
	}
	
	/**
	 * Simulates the offensive part of the face-off.
	 * If the player athlete's offense is greater than or equal to the opposing
	 * athlete's defense, the player wins the face-off and the match's fightWon method
	 * is called with the player athlete as the argument.
	 * Otherwise, the player athlete's stamina is decreased.
	 * 
	 * @param game   the game environment in which the face-off takes place
	 * @param match  the ongoing match
	 */
	public void playOffence(GameEnvironment game, Match match) {
		if (player.getPosition() == "CHASER" || player.getPosition() == "SEEKER") {
			if (player.getOffence() - opPlayer.getDefence() >=0) {
				match.fightWon(player);
			} else {
				player.staminaDecrease();
			}
		}
	}
	
	/**
	 * Simulates the defensive part of the face-off.
	 * If the player athlete's defense is greater than or equal to the opposing
	 * athlete's offense, the player wins the face-off and the match's fightWon method
	 * is called with the player athlete as the argument.
	 * Otherwise, the player athlete's stamina is decreased.
	 * 
	 * @param game   the game environment in which the face-off takes place
	 * @param match  the ongoing match
	 */
	public void playDefence(GameEnvironment game, Match match) {
		if (player.getPosition() == "BEATER" || player.getPosition() == "KEEPER") {
			if (player.getDefence() - opPlayer.getOffence() >=0) {
				match.fightWon(player);
			} else {
				player.staminaDecrease();
			}
		}
	}
}
