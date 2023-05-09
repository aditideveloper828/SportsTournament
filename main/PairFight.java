package main;

public class PairFight {
	
	private Athlete player;
	private Athlete opPlayer;
	
	public PairFight(Athlete athlete, Athlete opAthlete) {
		player = athlete;
		opPlayer = opAthlete;
	}
	
	public void playOffence(GameEnvironment game, Match match) {
		if (player.getPosition() == "CHASER" || player.getPosition() == "SEEKER") {
			if (player.getOffence() - opPlayer.getDefence() >=0) {
				match.fightWon();
			} else {
				// decreases the stamina of the player if they lose their face-off
				player.staminaDecrease();
			}
		}
	}
	
	public void playDefence(GameEnvironment game, Match match) {
		if (player.getPosition() == "BEATER") {
			if (player.getDefence() - opPlayer.getOffence() >=0) {
				match.fightWon();
			} else {
				// decreases the stamina of the player if they lose their face-off
				player.staminaDecrease();
			}
		}
	}
}
