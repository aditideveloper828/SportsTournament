package main;
import java.util.ArrayList;

public class Purchase {
	//return what?
	//add in try and except around if statements
	private String type;
	private PurchasableManager purchasable;
	private GameEnvironment game;
	
	public Purchase(String type, PurchasableManager purchasable, GameEnvironment game) {
		this.type = type;
		this.purchasable = purchasable;
		this.game = game;
			
	}
	
	
	public void displayOptions() {
		System.out.println("These are your options:");
		if (type == "ATHLETE") {
			ArrayList<Athlete> athletes = purchasable.getSomeAthletes(14);
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
	
	public void buy(Athlete chosen) {
		//deal with too many teams
		if (game.getBalance() >= chosen.getContractPrice()){
			purchasable.remove(chosen);
			game.reduceBalance(chosen.getContractPrice());			
		}
		else {
			System.out.println("You do not have enough points for this purchase.");
		}
		
		
		
	}
	
	public void buy(Item chosen) {
		if (game.getBalance() >= chosen.getContractPrice()){
			purchasable.remove(chosen);
			game.reduceBalance(chosen.getContractPrice());			
		}
		else {
			System.out.println("You do not have enough points for this purchase.");
		}
		
		
	}
	
	public void sell(Athlete chosen) {
		chosen.setPosition(null);
		purchasable.add(chosen);
		game.increaseBalance(chosen.getSellBackPrice());
		
		
		
	}
	
	
	public void sell(Item chosen) {
		purchasable.add(chosen);
		game.increaseBalance(chosen.getSellBackPrice());
		game.removeItem(chosen);
		
	}


}
