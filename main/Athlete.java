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
	private boolean injured = false;
	private boolean sick = false;
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
		return this.name;
	}
	
	public void chooseNickname(String name) {
		// sets the nickname of the athlete (if applied) given by the user
		nickname = name;
	}
	
	public int getOffence() {
		// pulls the offense rating of the Athlete. Judged out of 100
		return offenceRating;
	}
	
	public int getDefence() {
		// pulls the defense rating of the Athlete. Judged out of 100
		return defenceRating;
	}
	
	public int getStamina() {
		// pulls the current stamina of the Athlete
		return currentStamina;
	}
	
	public String getPosition() {
		return this.position;
	}


	public int getContractPrice() {
		// pulls cost of item
		return contractCost;
	}
	
	public int getSellBackPrice() {
		// pulls cost of selling item
		return sellBackPrice;
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
	
	public boolean isInjured() {
		return injured;
	}
	
	public void setInjury(boolean injury) {
		//add in something about creating an injury (random event)?
		injured = injury;
	}
	
	public void setSickness(boolean sickness) {
		//add in something about creating a sickness (random event)?
		sick = sickness;
	}
	
	
	public boolean isSick() {
		return sick;
	}
	
	
	
	public static void main(String[] args) {
		
		//Attempted to create an instance of Athlete here to experiment. Not sure where we will store the athletes... Just here?
		//int[] stats = new int[] {8, 5, 100, 30, 60};
		//Athlete theresaWise = new Athlete("Theresa Wise", "CHASER", stats);
		//System.out.println(theresaWise);
	}

	
	
}
