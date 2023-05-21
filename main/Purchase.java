package main;
import java.util.ArrayList;

/**
 * The Purchase class represents a purchase option in the game.
 * It allows the player to buy and sell athletes and items.
 * 
 * A Purchase object is associated with a specific type (either "ATHLETE" or "ITEM"),
 * a PurchasableManager object that manages the available athletes and items,
 * and a GameEnvironment object that represents the game environment.
 * 
 * This class provides methods to display available options, buy and sell athletes and items,
 * and handle the associated logic.
 * 
 * Note: The comparison of strings using the == operator may not be reliable.
 * It is recommended to use the equals() method for string comparison instead.
 * 
 * @author Aditi Sharma
 */

public class Purchase {
	//return what?
	//add in try and except around if statements
	private String type;
	private PurchasableManager purchasable;
	private GameEnvironment game;
	
	/**
	 * Constructs a Purchase object with the given type, purchasable manager, and game environment.
	 * 
	 * @param type the type of purchase ("ATHLETE" or "ITEM")
	 * @param purchasable the purchasable manager
	 * @param game the game environment
	 */
	public Purchase(String type, PurchasableManager purchasable, GameEnvironment game) {
		this.type = type;
		this.purchasable = purchasable;
		this.game = game;
	}
	
	/**
	 * Displays the available options for the purchase.
	 * If the type is "ATHLETE", it retrieves a certain number of athletes from the purchasable manager
	 * and displays their details.
	 * If the type is "ITEM", it retrieves all items from the purchasable manager and displays their details.
	 * 
	 * @param initializing true if the game is in the initialization phase, false otherwise
	 */
	public void displayOptions(boolean initializing) {
		System.out.println("These are your options:");
		if (type == "ATHLETE") {
			int toGet = 5;
			if (initializing) {
				toGet = 14;
			}
			ArrayList<Athlete> athletes = purchasable.getSomeAthletes(toGet);
			for (int i = 0; i < athletes.size(); i++){
				System.out.println("ID: "+(i+1));
				System.out.println(athletes.get(i));
				System.out.println();
			}
		}
		else {
			ArrayList<Item> items = purchasable.getAllItems();
			for (int i = 0; i < items.size(); i++){
				System.out.println("ID: "+(i+1));
				System.out.println(items.get(i));
				System.out.println();
			}
		}
	}
	
	/**
	 * Buys the chosen athlete and assigns them to the specified position.
	 * If the player has enough money (balance) for the purchase,
	 * the athlete is removed from the purchasable manager, assigned a position,
	 * and added to the game environment.
	 * The player's balance is reduced by the athlete's contract price.
	 * If the player does not have enough money, a message is displayed.
	 * 
	 * @param chosen the chosen athlete to buy
	 * @param position the position to assign to the athlete
	 */
	public void buy(Athlete chosen, String position) {
		//deal with too many teams
		if (game.getBalance() >= chosen.getContractPrice()){
			purchasable.remove(chosen);
			chosen.setPosition(position);
			if (chosen.getPosition() == "RESERVE") {
				game.addReserve(chosen);
			}
			else {
				game.addTeamMember(chosen);
			}
				
			game.reduceBalance(chosen.getContractPrice());			
		}
		else {
			System.out.println("You do not have enough points for this purchase.");
		}
	}
	
	/**
	 * Buys the chosen item.
	 * If the player has enough money (balance) for the purchase,
	 * the item is removed from the purchasable manager and added to the game environment.
	 * The player's balance is reduced by the item's contract price.
	 * If the player does not have enough money, a message is displayed.
	 * 
	 * @param chosen the chosen item to buy
	 */
	public void buy(Item chosen) {
		if (game.getBalance() >= chosen.getContractPrice()){
			purchasable.remove(chosen);
			game.reduceBalance(chosen.getContractPrice());
			game.addItem(chosen);
		}
		else {
			System.out.println("You do not have enough points for this purchase.");
		}
	}
	
	/**
	 * Sells the chosen athlete.
	 * If the athlete is in the reserve position, they are removed from the reserve list.
	 * If the athlete is in a team position, they are removed from the team.
	 * The athlete is added back to the purchasable manager,
	 * and the player's balance is increased by the athlete's sell back price.
	 * 
	 * @param chosen the chosen athlete to sell
	 */
	public void sell(Athlete chosen) {
		if (chosen.getPosition() == "RESERVE") {
			game.removeReserve(chosen);
		}
		else {
			game.removeTeamMember(chosen);
		}
		chosen.setPosition(null);
		purchasable.add(chosen);
		game.increaseBalance(chosen.getSellBackPrice());
	}
	
	/**
	 * Sells the chosen item.
	 * The item is added back to the purchasable manager,
	 * and the player's balance is increased by the item's sell back price.
	 * The item is also removed from the game environment.
	 * 
	 * @param chosen the chosen item to sell
	 */
	public void sell(Item chosen) {
		purchasable.add(chosen);
		game.increaseBalance(chosen.getSellBackPrice());
		game.removeItem(chosen);
		
	}


}
