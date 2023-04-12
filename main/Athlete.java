package main;


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
		// pulls the offense rating of the Athlete. Judged out of 100
		return offenceRating;
	}
	
	public static int getDefence() {
		// pulls the defense rating of the Athlete. Judged out of 100
		return defenceRating;
	}
	
	public static int getStamina() {
		// pulls the current stamina of the Athlete
		return currentStamina;
	}
	
	public String getPosition() {
		return Start.getPosition();
	}
	
	public boolean isInjured() {
		// create a randomInjury random event method??
		if (randomInjury() == true) {
			injured = true;
		}
		return injured;
	}
	
	public boolean isSick() {
		// create a randomSickness random event method??
		if (randomSickness() == true) {
			sick = true;
		}
		return injured;
	}
	
	public void status(playerStatus state) {
		// holds the switch case information for whether or not the Athlete is playing
		switch(state) {
			case ACTIVE:
				break;
			case RESERVE:
				break;
		}
	}
	
	public static void main(String[] args) {
		
		//Attempted to create an instance of Athlete here to experiment. Not sure where we will store the athletes... Just here?
		//Athlete theresaWise = new Athlete("Theresa Wise", 8, 5, 100, "CHASER");
	}
	
}
