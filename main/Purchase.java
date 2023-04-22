package main;
import java.util.ArrayList;

public class Purchase {
	//need to check if athlete has already been bought
	//return what?
	private String type;
	
	public Purchase(String type) {
		this.type = type;
		this.displayOptions();
		
	}
	
	public void displayOptions() {
		System.out.println("These are your options:");
		if (type == "ATHLETES") {
			ArrayList<Athlete> athletes = PurchasableManager.getAllAthletes();
			for (int i = 0; i < athletes.size(); i++){
				System.out.println(athletes.get(i));
				System.out.println();
			}
		}
		else {
			ArrayList<Item> items = PurchasableManager.getAllItems();
			for (int i = 0; i < items.size(); i++){
				System.out.println(items.get(i));
				System.out.println();
			}
		}
		
	}
	
	public void pickAthlete(String[] args) {
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
