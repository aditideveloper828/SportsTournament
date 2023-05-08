package main;

public class Athlete {
	
	String name;
	String nickname = name;
	private int offenceRating;
	private int defenceRating;
	private int currentStamina = 100;
	private double randomQuitProb = 1;
	private boolean injury = false;
	String position;
	
	public Athlete(String tempName, int oRating, int dRating, int cStamina) {
		// Constructor class to grab each detail about the athlete
		name = tempName;
		offenceRating = oRating;
		defenceRating = dRating;
		currentStamina = cStamina;
	}
	
	public String getName() {
		// pulls the name of the athlete
		return nickname;
	}
	
	public int getOffence() {
		// pulls the offence rating of the Athlete. Judged out of 100
		return offenceRating;
	}
	
	public int getDefence() {
		// pulls the defence rating of the Athlete. Judged out of 100
		return defenceRating;
	}
	
	public int getStamina() {
		// pulls the current stamina of the Athlete
		return currentStamina;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void staminaDecrease() {
		currentStamina -= 10;
	}
	
	public void statIncrease() {
		offenceRating += 1;
		defenceRating += 1;
	}
	
	public void staminaRefill() {
		currentStamina = 100;
		injury = false;
	}
	
	public boolean injured() {
		if (currentStamina == 0) {
			injury = true;
		}
		return injury;
	}
	
}
