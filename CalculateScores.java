import java.util.Random;

package SetUp;

public class CalculateScores {
	
	public int offenceRating = Athlete.getOffence();
	public int defenceRating = Athlete.getDefence();
	public int currentStamina = Athlete.getStamina();
	public int minOffence;
	public int maxOffence;
	public int minDefence;
	public int maxDefence;
	public int oPoints = 0;
	public int dPoints = 0;
	String position;
	
	// Will round the total score to the nearest 10 at the end?
	// Instead of rounding it throughout the whole process?
	
	// Also, I guess there will need to be a class/method where we calculate the entire team's score- maybe "Game"?
	
	public int pointsScored() {
		// holds the switch cases for the potential positions the Athlete can be
		// Calculates the points scored based on the athlete's offence and defence ratings
		switch(position) {
			case "SEEKER":
				break;
			
			case "CHASER":
				minOffence = offenceRating - 2;
				maxOffence = offenceRating + 1;
				// formula generates a random number in between minOffence and maxOffence inclusive
				//currentStamina example: if currentStamina = 76, the score will decrease to 76% of the original calculation
				oPoints = (((int)Math.random() * (maxOffence - minOffence + 1) + minOffence)*10)*(currentStamina/100);
				break;
				
			case "BEATER":
				break;
				
			case "KEEPER":
				minOffence = offenceRating - 4;
				maxOffence = offenceRating - 2;
				oPoints = (((int)Math.random() * (maxOffence - minOffence + 1) + minOffence)*10)*(currentStamina/100);
				break;
		}
		
		return oPoints;
	}
	
	public int pointsPrevented() {
		// holds the switch cases for the potential positions the Athlete can be
		// Calculates the points retracted from the opposing team based on the athlete's offence and defence ratings
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
				// formula generates a random number in between minDefence and maxDefence inclusive
				dPoints = (((int)Math.random() * (maxDefence - minDefence + 1) + minDefence)*10)*(currentStamina/100);
				break;
		}
		
		return dPoints;
	}
	
	
}
