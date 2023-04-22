package main;

public class Athlete implements Purchasable{
	//add in an id system?
	//have a check stamina class somewhere
	//change input format to an array
	String name;
	String nickname;
	public static int offenceRating;
	public static int defenceRating;
	public static int currentStamina = 100;
	String position;
	boolean injured = false;
	boolean sick = false;
	int contractCost;
	int sellBackPrice;
	
	public Athlete(String tempName, int oRating, int dRating, int cStamina, String position, int buyCost, int sellCost) {
		// Constructor class to grab each detail about the athlete
		name = tempName;
		nickname = name;
		offenceRating = oRating;
		defenceRating = dRating;
		currentStamina = cStamina;
		this.position = position;
		contractCost = buyCost;
		sellBackPrice = sellCost;
		
	}
	
	public void setPosition(String position) {
		// pulls the position of the athlete
		this.position = position;
	}
	
	public String getName() {
		// pulls the name of the athlete
		return this.name;
	}
	
	public void chooseNickname(String name) {
		// sets the nickname of the athlete (if applied) given by the user
		nickname = name;
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
	


	public int getContractPrice() {
		// pulls cost of item
		return contractCost;
	}
	
	public int getSellBackPrice() {
		// pulls cost of selling item
		return sellBackPrice;
	}
	
	public String getDescription(){
        //returns description
        return  "Athlete: "+name+"\nNickname: "+nickname+"\nOffence: "+offenceRating+"\nDefence: "+defenceRating+"\nPosition: "+position+" \nContract Cost: "+contractCost;
    }
	
	public String toString() {
		return this.getDescription();
	}
	/*
	 * public boolean isInjured() { // create a randomInjury random event method??
	 * if (randomInjury() == true) { injured = true; } return injured; }
	 * 
	 * public boolean isSick() { // create a randomSickness random event method?? if
	 * (randomSickness() == true) { sick = true; } return injured; }
	 * 
	 * public void status(playerStatus state) { // holds the switch case information
	 * for whether or not the Athlete is playing switch(state) { case ACTIVE: break;
	 * case RESERVE: break; } }
	 */
	
	public static void main(String[] args) {
		
		//Attempted to create an instance of Athlete here to experiment. Not sure where we will store the athletes... Just here?
		//Athlete theresaWise = new Athlete("Theresa Wise", 8, 5, 100, "CHASER", 30, 60);
		//System.out.println(theresaWise);
	}

	
	
}
