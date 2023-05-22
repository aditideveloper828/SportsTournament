package main;

public class ScreenManager {
	
	//private static PurchasableManager data;
	//private static GameEnvironment game;
	private Interaction implementation;
	
	/**
	 * Constructs a new ScreenManager object and initializes the Interaction implementation.
	 */
	public ScreenManager() {
		implementation = new Interaction();
	}
	
	/**
	 * Sets up the game with the specified name, duration, and difficulty.
	 *
	 * @param name       the name of the game
	 * @param duration   the duration of the game
	 * @param difficulty the difficulty level of the game
	 */
	public void makeGame(String name, int duration, int difficulty) {
		implementation.setUp(name, duration, difficulty);	
	}
	
	/**
	 * Returns the Interaction implementation.
	 *
	 * @return the Interaction implementation
	 */
	public Interaction getImplementation() {
		return implementation;
	}
	
	/**
	 * Launches the WelcomeScreen.
	 */
	public void launchWelcomeScreen() {
		WelcomeScreen screen = new WelcomeScreen(this);
	}
	
	/**
	 * Launches the SetUpScreen.
	 */
	public void launchSetUpScreen() {
		SetUpScreen screen = new SetUpScreen(this);
	}
	
	/**
	 * Launches the InitializeTeamScreen.
	 */
	public void launchInitializeTeamScreen() {
		InitializeTeam screen = new InitializeTeam(this);
	}
	
	/**
	 * Launches the PurchaseScreen.
	 */
	public void launchPurchaseScreen() {
		PurchaseScreen screen = new PurchaseScreen(this);
	}
	
	/**
	 * Launches the ClubScreen.
	 */
	public void launchClubScreen() {
		ClubScreen screen =  new ClubScreen(this);
	}
	
	/**
	 * Launches the MainScreen.
	 */
	public void launchMainScreen() {
		MainScreen screen = new MainScreen(this);
	}
	
	/**
	 * Launches the InitiateMatchScreen.
	 */
	public void launchInitiateMatchScreen() {
		InitiateMatchScreen screen = new InitiateMatchScreen(this);
	}
	
	/**
	 * Launches the ResultScreen.
	 */
	public void launchResultScreen() {
		ResultScreen screen = new ResultScreen(this);
	}
	
	/**
	 * Launches the ByeWeekScreen.
	 */
	public void launchByeWeekScreen() {
		ByeWeekScreen screen = new ByeWeekScreen(this);
	}
	
	/**
	 * Launches the FinishScreen.
	 */
	public void launchFinishScreen() {
		FinishScreen screen = new FinishScreen(this);
	}
	
	/**
	 * Closes the WelcomeScreen and launches the SetUpScreen.
	 *
	 * @param screen the WelcomeScreen to close
	 */
	public void closeWelcomeScreen(WelcomeScreen screen) {
		screen.closeWindow();
		launchSetUpScreen();
	}
	
	/**
	 * Closes the SetUpScreen and launches the InitializeTeamScreen.
	 *
	 * @param screen the SetUpScreen to close
	 */
	public void closeSetUpScreen(SetUpScreen screen) {
		screen.closeWindow();
		launchInitializeTeamScreen();
	}
	
	/**
	 * Closes the InitializeTeamScreen and launches the MainScreen.
	 *
	 * @param screen the InitializeTeamScreen to close
	 */
	public void closeInitializeTeamScreen(InitializeTeam screen) {
		screen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Closes the ByeWeekScreen and launches the MainScreen if there are remaining weeks,
	 * otherwise launches the FinishScreen.
	 *
	 * @param screen the ByeWeekScreen to close
	 */
	public void closeByeWeekScreen(ByeWeekScreen screen) {
		screen.closeWindow();
		if (implementation.remainingWeeks() > 0) {
			launchMainScreen();
		}
		else {
			launchFinishScreen();
		}
	}
	
	/**
	 * Closes the FinishScreen.
	 *
	 * @param screen the FinishScreen to close
	 */
	public void closeFinishScreen(FinishScreen screen) {
		screen.closeWindow();
	}
	
	/**
	 * Closes the ClubScreen and launches the MainScreen.
	 *
	 * @param screen the ClubScreen to close
	 */
	public void closeClubScreen(ClubScreen screen) {
		screen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Closes the PurchaseScreen and launches the MainScreen.
	 *
	 * @param screen the PurchaseScreen to close
	 */
	public void closePurchaseScreen(PurchaseScreen screen) {
		screen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Closes the ResultScreen and launches the FinishScreen if the game should end or there are no remaining weeks,
	 * otherwise launches the ByeWeekScreen if a bye week should be taken, or launches the MainScreen.
	 *
	 * @param screen the ResultScreen to close
	 */
	public void closeResultScreen(ResultScreen screen) {
		screen.closeWindow();
		if (implementation.shouldEndGame() || implementation.remainingWeeks() <= 0) {
			launchFinishScreen();
		}
		else if (implementation.shouldTakeBye()){
			launchByeWeekScreen();
		} 
		else {
			launchMainScreen();
		}
	}
	
	/**
	 * Closes the MainScreen.
	 *
	 * @param screen the MainScreen to close
	 */
	public void closeMainScreen(MainScreen screen) {
		screen.closeWindow();
	}
	
	/**
	 * Closes the InitiateMatchScreen and launches the ResultScreen.
	 *
	 * @param screen the InitiateMatchScreen to close
	 */
	public void closeInitiateMatchScreen(InitiateMatchScreen screen) {
		screen.closeWindow();
		launchResultScreen();
	}
	
	public void goHome() {
		launchMainScreen();
	}
	
	
	public static void main(String[] args) {
		ScreenManager manager = new ScreenManager();
		manager.launchWelcomeScreen();
		
	}
	
	
	
}
