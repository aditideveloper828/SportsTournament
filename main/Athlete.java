package main;

/**
 * The Athlete class represents an athlete that can be purchased in the game.
 * It implements the Purchasable interface.
 * An Athlete object has a name, offence rating, defence rating, current stamina,
 * position, injury status, contract cost, and sell back price.
 * The athlete's statistics can be boosted using items.
 * This class provides methods to access and modify the athlete's attributes,
 * such as getting the name, offence rating, defence rating, and current stamina,
 * setting the position, boosting the athlete's stats, and more.
 * 
 * hi how are you
 */
public class Athlete implements Purchasable{
	private String name;
	private int offenceRating;
	private int defenceRating;
	private int currentStamina = 100;
	private String position;
	private boolean injury = false;
	private int contractCost;
	private int sellBackPrice;
	
	/**
     * Constructs an Athlete object with the given name and statistics.
     *
     * @param tempName the name of the athlete
     * @param stats an array containing the athlete's statistics in the following order:
     *              [0] - offence rating
     *              [1] - defence rating
     *              [2] - contract cost
     *              [3] - sell back price
     */
	public Athlete(String tempName, int[] stats) {
		// Constructor class to grab each detail about the athlete
		name = tempName;
		offenceRating = stats[0];
		defenceRating = stats[1];
		contractCost = stats[3];
		sellBackPrice = stats[4];
	}
	
	/**
     * Sets the position of the athlete.
     *
     * @param position the position of the athlete
     */
	public void setPosition(String position) {
		// pulls the position of the athlete
		this.position = position;
	}
	
	/**
     * Limits the athlete's statistics to the valid range.
     */
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
	
	/**
     * Boosts the athlete's stats using the provided item.
     *
     * @param beingUsed the item being used to boost the athlete's stats
     */
	public void boost(Item beingUsed) {
		this.currentStamina += beingUsed.getStaminaBoost();
		this.offenceRating += beingUsed.getOffenceBoost();
		this.defenceRating += beingUsed.getDefenceBoost();
		limitor();
	}
	
	/**
     * Returns the name of the athlete.
     *
     * @return the name of the athlete
     */
	public String getName() {
		return name;
	}
	
	/**
     * Returns the offence rating of the athlete.
     *
     * @return the offence rating of the athlete
     */
	public int getOffence() {
		return offenceRating;
	}
	
	/**
     * Returns the defence rating of the athlete.
     *
     * @return the defence rating of the athlete
     */
	public int getDefence() {
		return defenceRating;
	}
	
	/**
     * Returns the current stamina of the athlete.
     *
     * @return the current stamina of the athlete
     */
	public int getStamina() {
		return currentStamina;
	}
	
	/**
     * Returns the position of the athlete.
     *
     * @return the position of the athlete
     */
	public String getPosition() {
		return position;
	}
	
	/**
     * Returns a description of the athlete.
     *
     * @return a description of the athlete
     */
	public String getDescription(){
        //returns description
        return  "Athlete: "+name+"\r\nOffence: "+offenceRating+"\r\nDefence: "+defenceRating+"\r\nPosition: "+position+" \r\nContract Cost: "+contractCost+"\r\nSell Back Price: "+sellBackPrice;
    }
	
	/**
     * Decreases the athlete's stamina by 20.
     */
	public void staminaDecrease() {
		currentStamina -= 20;
		limitor();
		
	}
 
	/**
     * Increases the athlete's offence and defence ratings by 1 and limits the stats to the valid range.
     */
	public void statIncrease() {
		offenceRating += 1;
		defenceRating += 1;
		limitor();
	}

	/**
     * Refills the athlete's stamina to its maximum value (100) and resets the injury status.
     */
	public void staminaRefill() {
		currentStamina = 100;
		injury = false;
	}
	
	/**
     * Checks if the athlete is injured.
     *
     * @return true if the athlete is injured (current stamina is 0), false otherwise
     */
	public boolean injured() {
		if (currentStamina == 0) {
			injury = true;
		}
		return injury;
	}
	
	/**
     * Returns a string representation of the athlete, which is the same as its description.
     *
     * @return a string representation of the athlete
     */
	public String toString() {
		return name + " Offence: " + offenceRating + " Defence: " + defenceRating + " Cost: $" + contractCost + " Sell back: $" + sellBackPrice + " Position: " + position;
	}

   /**
	* Returns the contract price of the athlete
	* 
	* @return the contract price of the athlete
	*/
	@Override
	public int getContractPrice() {
		// TODO Auto-generated method stub
		return contractCost;
	}

   /**
	* Returns the sell back price of the athlete
	* 
	* @return the sell back price of the athlete
	*/
	@Override
	public int getSellBackPrice() {
		// TODO Auto-generated method stub
		return sellBackPrice;
	}
}
