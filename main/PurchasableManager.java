package main;
import java.util.ArrayList;
import java.util.Random;


/**
 * The PurchasableManager class is responsible for managing athletes and items that can be purchased.
 * It provides methods to add, remove, and retrieve athletes and items.
 * 
 */
public class PurchasableManager{	
	
	private ArrayList<Athlete> athletes;
	private ArrayList<Item> items;
	private int availableAthletes = 0;
	private int availableItems = 0;
	
	/**
	 * Constructs a new PurchasableManager object.
	 * Initializes the lists of athletes and items.
	 */
	public PurchasableManager() {
		
		athletes = new ArrayList<Athlete>();
		availableAthletes = athletes.size();
		items = new ArrayList<Item>();
		availableItems = items.size();
		
	}
	
	/**
	 * Adds an athlete to the list of available athletes.
	 * 
	 * @param person the athlete to add
	 */
	public void add(Athlete person) {
		athletes.add(person);
		availableAthletes += 1;
	}
	
	/**
	 * Adds an item to the list of available items.
	 * 
	 * @param object the item to add
	 */
	public void add(Item object) {
		items.add(object);
		availableItems += 1;
	}
	
	/**
	 * Retrieves an athlete from the list of available athletes.
	 * 
	 * @param id the ID of the athlete to retrieve
	 * @return the retrieved athlete
	 */
	public Athlete getAthlete(int id) {
		return athletes.get(id);
	}
	
	/**
	 * Retrieves a random athlete from the list of available athletes.
	 * The retrieved athlete is removed from the list.
	 * 
	 * @return the random athlete
	 */
	public Athlete getRandAthlete(){
		Random randInt = new Random();
		int chosen = randInt.nextInt(availableAthletes);
		Athlete chosenAthlete = this.getAthlete(chosen);
		this.remove(chosenAthlete);
		return chosenAthlete;
	}
	
	/**
	 * Retrieves an item from the list of available items.
	 * 
	 * @param id the ID of the item to retrieve
	 * @return the retrieved item
	 */
	public Item getItem(int id) {
		return items.get(id);
	}
	
	/**
	 * Retrieves all the available athletes.
	 * 
	 * @return the list of all available athletes
	 */
	public ArrayList<Athlete> getAllAthletes() {
		//pulls all athletes available
		return athletes;
	}
	
	/**
	 * Retrieves a specified number of available athletes.
	 * If the requested number is greater than the available athletes, all available athletes are returned.
	 * 
	 * @param number the number of athletes to retrieve
	 * @return the list of retrieved athletes
	 */
	public ArrayList<Athlete> getSomeAthletes(int number){
		//pulls all athletes available
		if (number > availableAthletes) {
			number = availableAthletes;
		}
		ArrayList<Athlete> returnAthletes = new ArrayList<Athlete>();
		for (int i = 0; i < number; i++) {
			returnAthletes.add(athletes.get(i));
		}
		return returnAthletes;
	}
	
	/**
	 * Retrieves all the available items.
	 * 
	 * @return the list of all available items
	 */
	public ArrayList<Item> getAllItems() {
		//pulls all items available
		return items;
	}
	
	/**
	 * Removes an athlete from the list of available athletes.
	 * 
	 * @param person the athlete to remove
	 */
	public void remove(Athlete person) {
		athletes.remove(person);
		availableAthletes -= 1;
	}
	
	/**
	 * Removes an item from the list of available items.
	 * 
	 * @param object the item to remove
	 */
	public void remove(Item object) {
		items.remove(object);
		availableItems -= 1;
	}
	
	/**
	 * Retrieves the minimum contract price among the available athletes.
	 * 
	 * @return the minimum contract price
	 */
	public int minimumContractPrice() {
		int minimum = athletes.get(0).getContractPrice();
		for (int i = 1; i < availableAthletes; i++) {
			int price = athletes.get(i).getContractPrice();
			if (minimum > price) {
				minimum = price;
			}
		}
		return minimum;
	}	
}
