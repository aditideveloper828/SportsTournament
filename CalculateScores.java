import java.util.Random;

package SetUp;

public class CalculateScores {
	
	public int minOffence;
	public int maxOffence;
	public int minDefence;
	public int maxDefence;
	public int oPoints = 0;
	public int dPoints = 0;
	String position;
	
	public int pointsScored() {
		// holds the switch cases for the potential positions the Athlete can be
		switch(position) {
			case "SEEKER":
				break;
			
			case "CHASER":
				minOffence = offenceRating - 2;
				maxOffence = offenceRating + 1;
				oPoints = ((int)Math.random() * (maxOffence - minOffence + 1) + minOffence)* (currentStamina/10);
				break;
				
			case "BEATER":
				break;
				
			case "KEEPER":
				minOffence = offenceRating - 4;
				maxOffence = offenceRating - 2;
				oPoints = ((int)Math.random() * (maxOffence - minOffence + 1) + minOffence) * (currentStamina/10);
				break;
		}
		
		return oPoints;
	}
	
	public int pointsPrevented() {
		// holds the switch cases for the potential positions the Athlete can be
		switch(position) {
			case "SEEKER":
				break;
			
			case "CHASER":
				break;
				
			case "BEATER":
				dPoints = (defenceRating*(2/3)) * 10;
				break;
				
			case "KEEPER":
				minDefence = defenceRating - 3;
				maxDefence = defenceRating - 1;
				dPoints = ((int)Math.random() * (maxDefence - minDefence + 1) + minDefence) * (currentStamina/10);
				break;
		}
		
		return dPoints;
	}
	
	
}
