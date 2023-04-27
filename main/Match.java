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
	
	public static int teamTotal=0;
	
	public void matchSummary() {
		// printing the summary of the match (which athletes are playing each other)
		int i;
		for (i=0; i<GameEnvironment.getTeam().size(); i++) {
			/* Do we need to use the instance of "fight" since I have created it?
			 * */
			@SuppressWarnings("unused")
			PairFight fight = new PairFight(GameEnvironment.getTeam().get(i));
		}
			
	}
	
	public static void fightWon() {
		teamTotal += 1;
	}
	
	public int matchResult() {
		if (teamTotal >= 3) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

