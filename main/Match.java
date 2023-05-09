package main;
import java.util.*;

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
		// printing the summary of the match (which athletes are playing each other)
		//does not print anything at the moment
		int i;
		for (i=0; i<game.getTeam().size(); i++) {
			PairFight fight = new PairFight(game.getTeam().get(i), opposition.getOpTeam().get(i));
			fight.playOffence(game, this);
			fight.playDefence(game, this);
		}
			
	}
	
	public void fightWon() {
		teamTotal += 1;
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
