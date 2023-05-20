package main;

public class CannotPlay extends Exception{
		
	public CannotPlay() {
		super();
	}
	
	public CannotPlay(String message, GameEnvironment game, int duration) {
		super();
		System.out.println(message);
		System.out.println("Your Final Status!!!");
	    System.out.println("Team Name: "+game.getTeamName());
	    System.out.println("Selected Season Duration: "+duration);
		System.out.println("Final Balance: "+game.getBalance());
		System.out.println("Total Points: "+game.getPoints());
		System.exit(0);
		
	}

}
