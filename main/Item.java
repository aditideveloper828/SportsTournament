package main;

/**
 * Represents an item that can be purchased.
 * Implements the Purchasable interface.
 */

public class Item implements Purchasable{
	//change boosts to percentages?
	//change so that attributes cannot be changed after being set
	//change input format to an array
	String name;
	public int offenceBoost;
	public int defenceBoost;
	public int staminaBoost;
	int contractCost;
	int sellBackPrice;
	
	/**
     * Constructs a new Item object with the specified name and statistics.
     *
     * @param itemName the name of the item
     * @param stats an array of statistics including defense boost, offense boost, stamina boost,
     *              contract cost, and sell back price
     */
	public Item(String itemName, int[] stats) {
		name = itemName;
		defenceBoost = stats[0];
		offenceBoost = stats[1];
		staminaBoost = stats[2];
		contractCost = stats[3];
		sellBackPrice = stats[4];
		
	}
	
	/**
     * Retrieves the offensive boost provided by the item.
     *
     * @return the offensive boost of the item (measured on a scale of 0 to 100)
     */
	public int getOffenceBoost() {
		return offenceBoost;
	}
	
	/**
     * Retrieves the defensive boost provided by the item.
     *
     * @return the defensive boost of the item (measured on a scale of 0 to 100)
     */
	public int getDefenceBoost() {
		return defenceBoost;
	}
	
	/**
     * Retrieves the stamina boost provided by the item.
     *
     * @return the stamina boost of the item
     */
	public int getStaminaBoost() {
		return staminaBoost;
	}
	
	/**
     * Retrieves the cost of the item when purchasing a contract.
     *
     * @return the contract cost of the item
     */
	public int getContractPrice() {
		return contractCost;
	}
	
	/**
     * Retrieves the price at which the item can be sold back.
     *
     * @return the sell back price of the item
     */
	public int getSellBackPrice() {
		return sellBackPrice;
	}
	
	/**
     * Retrieves the description of the item, including its name, offense boost, defense boost,
     * stamina boost, and contract cost.
     *
     * @return the description of the item
     */
	public String getDescription(){
        return  "Item: "+name+"\n Offence Boost: "+offenceBoost+"\n Defence Boost: "+defenceBoost+"\n Stamina Boost: "+staminaBoost+"\n Contract Cost: "+contractCost;
    }
	
	/**
     * Returns a string representation of the item, which is the same as its description.
     *
     * @return a string representation of the item
     */
	public String toString() {
		return this.getDescription();
	}


	
}
