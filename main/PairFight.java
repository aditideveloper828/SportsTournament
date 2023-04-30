package main;

public class PairFight {
	
	private Athlete player;
	private Athlete opPlayer;
	
	public PairFight(Athlete athlete, Athlete opAthlete) {
		player = athlete;
		opPlayer = opAthlete;
	}
	
	public void playOffence(GameEnvironment game) {
		if (player.getPosition() == "CHASER" || player.getPosition() == "SEEKER") {
			if (player.getOffence() - opPlayer.getDefence() >=0) {
				Match.fightWon();
			}
		}
	}
	
	public void playDefence(GameEnvironment game) {
		if (player.getPosition() == "BEATER") {
			if (player.getDefence() - opPlayer.getOffence() >=0) {
				Match.fightWon();
			}
		}
	}
}
