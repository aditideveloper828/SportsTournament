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
	}
	
	public void buy(Item chosen) {
		if (game.getBalance() >= chosen.getContractPrice()){
			purchasable.remove(chosen);
			game.reduceBalance(chosen.getContractPrice());
			game.addItem(chosen);
		}	
		
	}
	
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
	
	
	public void sell(Item chosen) {
		purchasable.add(chosen);
		game.increaseBalance(chosen.getSellBackPrice());
		game.removeItem(chosen);
		
	}


}
