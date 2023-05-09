package main;

/**
 * @author Imogen Keeling
 *
 */


public class Athlete implements Purchasable{
	//add in an id system?
	//have a check stamina class somewhere
	//change input format to an array
	private String name;
	private String nickname;
	private int offenceRating;
	private int defenceRating;
	private int currentStamina = 100;
	private String position;
	private boolean injury = false;
	private int contractCost;
	private int sellBackPrice;
	private int probRandomEvent = 10;
	
	public Athlete(String tempName, int[] stats) {
		// Constructor class to grab each detail about the athlete
		name = tempName;
		nickname = name;
		offenceRating = stats[0];
		defenceRating = stats[1];
		currentStamina = stats[2];
		contractCost = stats[3];
		sellBackPrice = stats[4];
		
	}
	
	//add setter method choosing position && change display to not include position
	
	public void setPosition(String position) {
		// pulls the position of the athlete
		this.position = position;

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
	
	public void changeRandEventProb(int change) {
		//changes probability of a random event
		probRandomEvent += change;
		
	}
	
	public int getRandEventProb() {
		//changes probability of a random event
		return probRandomEvent;
		
	}
	
	public String getDescription(){
        //returns description
        return  "Athlete: "+name+"\nNickname: "+nickname+"\nOffence: "+offenceRating+"\nDefence: "+defenceRating+"\nPosition: "+position+" \nContract Cost: "+contractCost;
    }
	
	public String toString() {
		return this.getDescription();
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

	@Override
	public int getContractPrice() {
		// TODO Auto-generated method stub
		return contractCost;
	}

	@Override
	public int getSellBackPrice() {
		// TODO Auto-generated method stub
		return sellBackPrice;
	}
	
}
