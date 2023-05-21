package main;

/**
 * Represents a match between the player's team and an opposition team.
 * Keeps track of the team's total wins and determines if the match is won.
 * If the team has won: matchResult() will return 1
 * If the team has lost: matchResult() will return 0
 * 
 * @author Imogen Keeling
 */

public class Match {
	
	private int teamTotal=0;
	
	/**
	 * Constructs a new Match object with the given game environment and opposition team.
	 *
	 * @param game the game environment
	 * @param opposition the opposition team
	 */
	public Match(GameEnvironment game, OppositionTeam opposition) {
		matchSummary(game, opposition);
	}
	
	/**
	 * Plays the match and updates the team's total wins.
	 *
	 * @param game the game environment
	 * @param opposition the opposition team
	 */
	public void matchSummary(GameEnvironment game, OppositionTeam opposition) {
		int i;
		for (i=0; i < 7; i++) {
			PairFight fight = new PairFight(game.getTeamMember(i), opposition.getOpTeam().get(i));
			fight.playOffence(game, this);
			fight.playDefence(game, this);
		}	
	}
	
	/**
	 * Updates the team's total wins when a fight is won by a player.
	 *
	 * @param player the player who won the fight
	 */
	public void fightWon(Athlete player) {
		if (player.injured() == false) {
			teamTotal += 1;
		}
	}
	
	/**
	 * Checks if the team has won the match.
	 *
	 * @return true if the team has won, false otherwise
	 */
	public boolean matchWon() {
		
		if (teamTotal >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retrieves the team's total wins in the match.
	 *
	 * @return the team's total wins
	 */
	public int getTeamTotal() {
		return this.teamTotal;
	}
	
}
