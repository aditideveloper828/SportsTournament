package SetUp;

/**
 * @author Imogen Keeling
 *
 */

public class Athlete {
	
	String name;
	String nickname = name;
	public static int offenceRating;
	public static int defenceRating;
	public static int currentStamina = 100;
	String position;
	boolean injured = false;
	boolean sick = false;
	
	public Athlete(String tempName, int oRating, int dRating, int cStamina, String chosenPosition) {
		// Constructor class to grab each detail about the athlete
		name = tempName;
		offenceRating = oRating;
		defenceRating = dRating;
		currentStamina = cStamina;
		position = chosenPosition;
	}
	
	public String getName() {
		// pulls the name of the athlete
		return this.name;
	}
	
	public String chooseNickname() {
		// pulls the nickname of the athlete (if applied) given by the user
		name = Start.getNickName();
	}
	
	public static int getOffence() {
		// pulls the offence rating of the Athlete. Judged out of 100
		return offenceRating;
	}
	
	public static int getDefence() {
		// pulls the defence rating of the Athlete. Judged out of 100
		return defenceRating;
	}
	
	public static int getStamina() {
		// pulls the current stamina of the Athlete
		return currentStamina;
	}
	
	public String getPosition() {
		return Start.getPosition();
	}
	
	public static void main(String[] args) {
		
	}
	
}
