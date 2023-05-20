package main;

/**
 * @author Imogen Keeling
 *
 */

///remove nicknames

public class Athlete implements Purchasable{
	private String name;
	private String nickname;
	private int offenceRating;
	private int defenceRating;
	private int currentStamina = 100;
	private String position;
	private boolean injury = false;
	private int contractCost;
	private int sellBackPrice;
	
	public Athlete(String tempName, int[] stats) {
		// Constructor class to grab each detail about the athlete
		name = tempName;
		nickname = name;
		offenceRating = stats[0];
		defenceRating = stats[1];
		contractCost = stats[3];
		sellBackPrice = stats[4];
		
	}
	
	
	public void setPosition(String position) {
		// pulls the position of the athlete
		this.position = position;

	}
	
	private void limitor() {
		if (currentStamina > 100) {
			currentStamina = 100;
		}
		if (offenceRating > 10) {
			offenceRating = 10;
		}
		if (defenceRating > 10) {
			defenceRating = 10;
		}
		if (currentStamina < 0) {
			currentStamina = 0;
		}
		
	}
	
	public void boost(Item beingUsed) {
		this.currentStamina += beingUsed.getStaminaBoost();
		this.offenceRating += beingUsed.getOffenceBoost();
		this.defenceRating += beingUsed.getDefenceBoost();
		limitor();

	}
	
	public String getName() {
		// pulls the name of the athlete
		return name;
	}
	
	public void setNickname(String name) {
		nickname = name;
	}
	
	public int getOffence() {
		// pulls the offence rating of the Athlete. Judged out of 10
		return offenceRating;
	}
	
	public int getDefence() {
		// pulls the defence rating of the Athlete. Judged out of 10
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
		currentStamina -= 20;
		limitor();
		
	}
	
	public String getDescription(){
        //returns description
        return  "Athlete: "+name+"\r\nOffence: "+offenceRating+"\r\nDefence: "+defenceRating+"\r\nPosition: "+position+" \r\nContract Cost: "+contractCost+"\r\nSell Back Price: "+sellBackPrice;
    }
	
	public String toString() {
		return name + " Offence: " + offenceRating + " Defence: " + defenceRating + " Cost: $" + contractCost + " Sell back: $" + sellBackPrice + " Position: " + position;
	}
	
	public void statIncrease() {
		offenceRating += 1;
		defenceRating += 1;
		limitor();
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
