package main;

/**
 * The Purchasable interface represents an item that can be purchased.
 * It defines the common behavior and properties of a purchasable item.
 *
 * @author Aditi
 *
 */
public interface Purchasable {
	
   /**
	* Returns the contract price of the athlete
	* 
	* @return the contract price of the athlete
	*/
	public int getContractPrice();
	
   /**
	* Returns the sell back price of the athlete
	* 
	* @return the sell back price of the athlete
	*/
	public int getSellBackPrice();
	
   /**
    * Returns a description of the athlete.
    *
    * @return a description of the athlete
    */
	public String getDescription();

}
