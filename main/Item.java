package main;

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
	
	
	public int getOffenceBoost() {
		// pulls the offense boost of the item. Judged out of 100
		return offenceBoost;
	}
	
	public int getDefenceBoost() {
		// pulls the defense boost of the item. Judged out of 100
		return defenceBoost;
	}
	
	public int getStaminaBoost() {
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
        return  "Item: "+name+"\n Offence Boost: "+offenceBoost+"\n Defence Boost: "+defenceBoost+"\n Stamina Boost: "+staminaBoost+"\n Contract Cost: "+contractCost;
    }
	
	public String toString() {
		return this.getDescription();
	}


	
}
