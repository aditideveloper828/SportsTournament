package main;

/**
 * @author Imogen Keeling
 *
 */

public class Match {

	/* 
	 * Indicating whether the team has won or lost
	 * If the team has won: matchResult() will return 1
	 * If the team has lost: matchResult() will return 0
	 * */
	
	private int teamTotal=0;
	public Match(GameEnvironment game, OppositionTeam opposition) {
		matchSummary(game, opposition);

	}
	
	public void matchSummary(GameEnvironment game, OppositionTeam opposition) {
		int i;
		for (i=0; i < 7; i++) {
			PairFight fight = new PairFight(game.getTeamMember(i), opposition.getOpTeam().get(i));
			fight.playOffence(game, this);
			fight.playDefence(game, this);
		}	
	}
	
	public void fightWon(Athlete player) {
		if (player.injured() == false) {
			teamTotal += 1;
		}
	}
	
	public boolean matchWon() {
		
		if (teamTotal >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getTeamTotal() {
		return this.teamTotal;
	}
	
}
