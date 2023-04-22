/**
 * 
 */
package main;
import java.util.ArrayList;
/**
 * @author Aditi
 *
 */
public class PurchasableManager {
	//need some sort of text file containing profiles and a 
	//class that automatically creates athletes by reading from that file
	
	private static ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private static ArrayList<Item> items = new ArrayList<Item>();
	
	public PurchasableManager(Athlete person) {
		athletes.add(person);
	}
	
	public PurchasableManager(Item object) {
		items.add(object);
	}
	
	public static ArrayList<Athlete> getAllAthletes() {
		//pulls all athletes available
		return athletes;
	}
	
	public static ArrayList<Item> getAllItems() {
		//pulls all items available
		return items;
	}
	
	

}
