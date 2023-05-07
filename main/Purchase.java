package main;
import java.util.ArrayList;

public class Purchase {
	//need to check if athlete has already been bought
	//return what?
	private String type;
	
	public Purchase(String type, PurchasableManager purchasable) {
		this.type = type;
		this.displayOptions(purchasable);
		
	}
	
	public void displayOptions(PurchasableManager purchasable) {
		System.out.println("These are your options:");
		if (type == "ATHLETES") {
			ArrayList<Athlete> athletes = purchasable.getAllAthletes();
			for (int i = 0; i < athletes.size(); i++){
				System.out.println(athletes.get(i));
				System.out.println();
			}
		}
		else {
			ArrayList<Item> items = purchasable.getAllItems();
			for (int i = 0; i < items.size(); i++){
				System.out.println(items.get(i));
				System.out.println();
			}
		}
		
	}
	
	public void pickAthlete(String[] args) {
		
	}


}
