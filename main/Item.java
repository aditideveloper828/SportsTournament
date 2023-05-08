package main;

public class Item implements Purchasable{
	//change boosts to percentages?
	//change so that attributes cannot be changed after being set
	//change input format to an array
	String name;
	public static int offenceBoost;
	public static int defenceBoost;
	public static int staminaBoost;
	int contractCost;
	int sellBackPrice;
	
	public Item(String itemName, int[] stats) {
		name = itemName;
		defenceBoost = stats[0];
		offenceBoost = stats[1];
		staminaBoost = stats[2];
		contractCost = stats[3];
		sellBackPrice = stats[4];
		
	}
	
	public String getName() {
		// pulls the name of the item
		return this.name;
	}
	
	
	public static int getOffenceBoost() {
		// pulls the offense boost of the item. Judged out of 100
		return offenceBoost;
	}
	
	public static int getDefenceBoost() {
		// pulls the defense boost of the item. Judged out of 100
		return defenceBoost;
	}
	
	public static int getStaminaBoost() {
		// pulls the stamina boost of the item
		return staminaBoost;
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
        return  "Item: "+name+"\nOffence Boost: "+offenceBoost+"\nDefence Boost: "+defenceBoost+"\nStamina Boost: "+staminaBoost+"\nContract Cost: "+contractCost;
    }
	
	public String toString() {
		return this.getDescription();
	}


	
}
