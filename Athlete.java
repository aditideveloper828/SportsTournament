package SetUp;

public class Athlete {
	
	String name;
	String nickname = name;
	public int offenceRating;
	public int defenceRating;
	public int currentStamina = 100;
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
	
	public int getOffence() {
		// pulls the offence rating of the Athlete. Judged out of 100
		return this.offenceRating;
	}
	
	public int getDefence() {
		// pulls the defence rating of the Athlete. Judged out of 100
		return this.defenceRating;
	}
	
	public int getStamina() {
		// pulls the current stamina of the Athlete
		return this.currentStamina;
	}
	
	public String getPosition() {
		return this.position;
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
		Athlete theresaWise = new Athlete("Theresa Wise", 8, 5, 100, "CHASER");
	}
	
}
