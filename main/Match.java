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
	
	private static int teamTotal=0;
	
	public void matchSummary(GameEnvironment game, OppositionTeam opposition) {
		// printing the summary of the match (which athletes are playing each other)
		int i;
		for (i=0; i<game.getTeam().size(); i++) {
			/* Do we need to use the instance of "fight" since I have created it?
			 * */
			@SuppressWarnings("unused")
			PairFight fight = new PairFight(game.getTeam().get(i), opposition.getOpTeam().get(i));
		}
			
	}
	
	public static void fightWon() {
		teamTotal += 1;
	}
	
	public boolean matchWon() {
		if (teamTotal >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
}
