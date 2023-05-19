/**
 * 
 */
package main;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Aditi Sharma
 *
 */
public class PurchasableManager extends IncorrectInput {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Athlete> athletes;
	private ArrayList<Item> items;
	private int availableAthletes = 0;
	private int availableItems = 0;
	
	public PurchasableManager() {
		
		athletes = new ArrayList<Athlete>();
		availableAthletes = athletes.size();
		items = new ArrayList<Item>();
		availableItems = items.size();
		
	}
	
	public void add(Athlete person) {
		athletes.add(person);
		availableAthletes += 1;
		
	}
	
	public void add(Item object) {
		items.add(object);
		availableItems += 1;
	}
	
	public Athlete getAthlete(int id) {
		return athletes.get(id);
		
	}
	
	public Athlete getRandAthlete(){
		Random randInt = new Random();
		int chosen = randInt.nextInt(availableAthletes);
		Athlete chosenAthlete = this.getAthlete(chosen);
		this.remove(chosenAthlete);
		return chosenAthlete;
		
	}
	
	public Item getItem(int id) {
		return items.get(id);
	}
	
	
	
	public void remove(Athlete person) {
		athletes.remove(person);
		availableAthletes -= 1;
	}
	
	public void remove(Item object) {
		items.remove(object);
		availableItems -= 1;
	}

	public ArrayList<Athlete> getAllAthletes() {
		//pulls all athletes available
		return athletes;
	}
	
	public ArrayList<Athlete> getSomeAthletes(int number) throws IncorrectInput {
		//pulls all athletes available
		if (number > availableAthletes) {
			number = availableAthletes;
		}
		ArrayList<Athlete> randomFew = new ArrayList<Athlete>();
		ArrayList<Integer> alreadySelected = new ArrayList<Integer>();
		while (number > 0) {
			Random athleteInd = new Random();
			int index = athleteInd.nextInt(availableAthletes);
			if (alreadySelected.contains(index) != true) {
				randomFew.add(athletes.get(index));
				alreadySelected.add(index);
				number -= 1;
			}
		}
		return randomFew;
	}
	
	
	public ArrayList<Item> getAllItems() {
		//pulls all items available
		return items;
	}
	
	public int numAthletes() {
		return availableAthletes;
	}
	
	public int numItems() {
		return availableItems;
	}
	
	
	
	

}
