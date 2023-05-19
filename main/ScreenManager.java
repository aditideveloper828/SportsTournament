package main;

public class ScreenManager {
	
	private static PurchasableManager data;
	private static GameEnvironment game;
	
	public ScreenManager() {
		
	}
	
	public void setGame(GameEnvironment game) {
		this.game = game;
		this.data = game.getMarket();
	}
	
	public void launchWelcomeScreen() {
		WelcomeScreen screen = new WelcomeScreen(this);
	}
	
	public void launchSetUpScreen() {
		SetUpScreen screen = new SetUpScreen(this);
	}
	
	public void launchBuyTeamScreen() {
		BuyTeamScreen screen = new BuyTeamScreen(data, this,  game);
	}
	
	public void launchPurchaseScreen() {
		PurchaseScreen screen = new PurchaseScreen(data, this);
	}
	
	public void launchClubScreen() {
		ClubScreen screen =  new ClubScreen(data, game, this);
	}
	
	public void launchMainScreen() {
		MainScreen screen = new MainScreen(this);
	}
	
	public void launchInitiateMatchScreen() {
		InitiateMatchScreen screen = new InitiateMatchScreen(data, this, game);
	}
	
	public void launchResultScreen() {
		ResultScreen screen = new ResultScreen(this);
	}
	
	public void closeWelcomeScreen(WelcomeScreen screen) {
		screen.closeWindow();
		launchSetUpScreen();
	}
	
	public void closeSetUpScreen(SetUpScreen screen) {
		screen.closeWindow();
		launchBuyTeamScreen();
	}
	
	public void closeBuyTeamScreen(BuyTeamScreen screen) {
		screen.closeWindow();
		launchMainScreen();
	}
	
	public void closeMainScreen(MainScreen screen) {
		screen.closeWindow();
	}
	
	public void closeInitiateMatchScreen() {
		InitiateMatchScreen.closeWindow();
		launchResultScreen();
	}
	
	public void goHome(ScreenCase state) {
		switch (state) {
        case PURCHASESCREEN:
        	PurchaseScreen.closeWindow();
            break;
        case CLUBSCREEN:
        	ClubScreen.closeWindow();
            break;
		default:
			break;
		}
		
		launchMainScreen();
	}
	
	public void goBack(ScreenCase state) {
		switch (state) {
		case CHOOSEOPTEAMSCREEN:
			InitiateMatchScreen.closeWindow();
			launchMainScreen();
		default:
			break;
		}
		
		
	}
	
	public static void main(String[] args) {
		ScreenManager manager = new ScreenManager();
		manager.launchWelcomeScreen();
		
	}
	
}
