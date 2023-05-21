package main;

/**
 * The Purchasable interface represents an item that can be purchased.
 * It defines the common behavior and properties of a purchasable item.
 *
 * @author Aditi
 *
 */
public interface Purchasable {
	
	public int getContractPrice();
	public int getSellBackPrice();
	public String getDescription();

}
