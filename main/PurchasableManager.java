/**
 * 
 */
package main;
import java.util.ArrayList;
/**
 * @author Aditi Sharma
 *
 */
public class PurchasableManager {
	//need some sort of text file containing profiles and a 
	//class that automatically creates athletes by reading from that file
	
	private ArrayList<Athlete> athletes;
	private ArrayList<Item> items;
	
	public PurchasableManager() {
		
		athletes = new ArrayList<Athlete>();
		items = new ArrayList<Item>();
		
	}
	
	public void add(Athlete person) {
		athletes.add(person);
		
	}
	
	public void add(Item object) {
		items.add(object);
	}
	
	public void remove(Athlete person) {
		athletes.remove(person);
	}
	
	public void remove(Item object) {
		items.remove(object);
	}
	
	public ArrayList<Athlete> getAllAthletes() {
		//pulls all athletes available
		return athletes;
	}
	
	public ArrayList<Item> getAllItems() {
		//pulls all items available
		return items;
	}
	
	

}
