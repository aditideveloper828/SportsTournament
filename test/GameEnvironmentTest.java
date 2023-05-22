package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import main.Athlete;
import main.FileRead;
import main.GameEnvironment;

public class GameEnvironmentTest {
	private static GameEnvironment game = new GameEnvironment("Default", 2);
	private static ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//making athletes
		FileRead athleteFile = new FileRead("AthleteProfiles");
		ArrayList<String> athleteProfiles = athleteFile.getData();
		for (int i = 1; i < athleteProfiles.size(); i++) {
			String[] characterData = athleteProfiles.get(i).split(";",0);
			int [] stats = new int[5];
			for (int j = 0; j < 5; j++){
				stats[j] = 	 Integer.parseInt(characterData[j+2]);
			}
			String name = characterData[0] + " " + characterData[1];
			try {
				athletes.add(new Athlete(name, stats));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Sets up a mock team of the first 7 athletes in the athlete array list provided by PurchasableManger
	 */
	@BeforeAll
	static void setUpTeam() {
		for (int i=0; i<7; i++) {
			Athlete athlete = athletes.get(i);
			game.addTeamMember(athlete);
		}
		
		for (int x=0; x<4; x++) {
			Athlete athlete = athletes.get(x);
			game.addReserve(athlete);
		}
	}
	
	/*
	 * Test method for {@link main.GameEnvironment#addTeamMember()}
	 * Tests that the addTeamMember() and addReserve() called in setUpTeam()
	 * created a team array and reserved array of the intended size.
	 */
	@Test
	void testTeamSize() {
		assertEquals(7, game.getTeamSize());
		assertEquals(4, game.getReserveSize());
		
		// where is the error-checking method for checking the size of the reserves?
	}
	
	/*
	 * Test method for {@link main.GameEnvironment#removeReserve()}
	 * checks the size of the athlete reserve group before and after the removeReserve() method has been applied.
	 * Makes sure that a reserve has been removed.
	 */
	@Test
	void testRemoveReserve() {
		int prevReserveSize = game.getReserveSize();
		game.removeReserve(game.getReserves().get(0));
		int finalReserveSize = game.getReserveSize();
		int sizeDifference = prevReserveSize - finalReserveSize;
		assertEquals(1, sizeDifference);
	}
	
	/*
	 * Test method for {@link main.GameEnvironment#teamStaminaRefill()}
	 * Reduces the stamina of the athletes in the team, 
	 * then checks that the teamStaminaRefill() refills the stamina of every team member
	 */
	@Test
	void testTeamStaminaRefill() {
		for (int i=0; i<game.getTeamSize(); i++) {
			game.getTeam().get(i).staminaDecrease();
		}
		game.teamStaminaRefill();
		for (int i=0; i<game.getTeamSize(); i++) {
			int athleteStamina = game.getTeam().get(i).getStamina();
			assertEquals(100, athleteStamina);
		}
	}
	
	/*
	 * Test method for {@link main.GameEnvironment#reduceBalance()} and {@link main.GameEnvironment#resetBalance()}
	 * Checks that the reduceBalance decreases the balance by the amount that is passed into it
	 * Calls different amounts of money to reduce
	 * Tests that the difference in balance is the same as the requested reduction,
	 * and that the balance is always greater than or equal to 0,
	 * and that when the resetBalance() method is called, the balance returns to 100.
	 */
	@Test
	void testReduceBalance() {
		for (int i=0; i<=game.getBalance(); i+=10) {
			
			int prevBalance = game.getBalance();
			game.reduceBalance(i);
			int newBalance = game.getBalance();
			int balanceDiff = prevBalance - newBalance;
			
			assertEquals(i, balanceDiff);
			assertTrue(game.getBalance()>=0);
			
			game.resetBalance();
			assertEquals(100, game.getBalance());
		}
	}
	
	/*
	 * Test method for {@link main.GameEnvironment#reduceWeek()}
	 * Checks that the remaining weeks reduces by 1 when the function is called
	 */
	@Test
	void testReduceWeek() {
		int prevWeekNum = game.getWeeks();
		game.reduceWeek();
		int newWeekNum = game.getWeeks();
		int weekDiff = prevWeekNum - newWeekNum;
		
		assertEquals(1, weekDiff);
	}
}
