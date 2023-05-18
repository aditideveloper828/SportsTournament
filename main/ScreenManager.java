package main;

public class ScreenManager {
	
	public static PurchasableManager data;
	
	public ScreenManager(PurchasableManager incomingData) {
		data = incomingData;
	}
	
	public void launchWelcomeScreen() {
		WelcomeScreen screen = new WelcomeScreen(this);
	}
	
	public void launchSetUpScreen() {
		SetUpScreen screen = new SetUpScreen(this);
	}
	
	public void launchPurchaseScreen() {
		PurchaseScreen screen = new PurchaseScreen(data, this);
	}
	
	public void closeWelcomeScreen(WelcomeScreen screen) {
		screen.closeWindow();
		launchSetUpScreen();
	}
	
	public void closeSetUpScreen(SetUpScreen screen) {
		screen.closeWindow();
		launchPurchaseScreen();
	}
	
	public static void main(String[] args) {
		ScreenManager manager = new ScreenManager(data);
		manager.launchWelcomeScreen();
		
	}
	
}
