package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.Athlete;
import main.Interaction;

/**
 * Test class to test the method in the interaction class
 *
 */
public class InteractionTest {
	private static Interaction implementation = new Interaction();
	private static ArrayList<Athlete> athletes = implementation.getMarket().getAllAthletes();
	
	
	@BeforeAll
	static void setUpBeforeClass() {
		implementation.setUp("deafult", 5, 1);
	}
		//making athletes
	
	/*
	 * Sets up a mock team of the first 8 athletes in the athlete array list provided by PurchasableManger
	 */
	@BeforeAll
	static void setUpTeam() {
		String[] positions = {"SEEKER", "KEEPER", "BEATER", "BEATER", "CHASER", "CHASER", "CHASER", "RESERVE"};
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		for (int i=0; i<8; i++) {
			Athlete athlete = athletes.get(i);
			athlete.setPosition(positions[i]);
			team.add(athlete);
		}
		
		implementation.initializeTeam(team);
	}
	
	/*
	 * Test method for {@link main.Interaction#sell()}
	 * Ensures that the sell method reduces the number of athletes in the team by one.
	 */
	@Test 
	void testSell() {
		int initialSize = implementation.getGame().getTeamSize();
		implementation.sell(3,2,"BEATER");
		int finalSize = implementation.getGame().getTeamSize();
		int sizeDifference = initialSize - finalSize;
		assertEquals(1,sizeDifference);
	}
	
	/*
	 * Test method for {@link main.Interaction#buy()}
	 * Ensures that the sell method reduces the number of athletes in the team by one.
	 */
	@Test 
	void testBuy() {
		implementation.getGame().increaseBalance(1000);
		String[] positions = {"SEEKER", "KEEPER", "BEATER", "BEATER", "CHASER", "CHASER", "CHASER", "RESERVE"};
		for (int i=0;i<positions.length;i++) {
			if (positions[i] == "RESERVE") {
				int initialSize = implementation.getGame().getReserveSize();
				implementation.buy(athletes.get(0),"RESERVE");
				int finalSize = implementation.getGame().getReserveSize();
				int sizeDifference = finalSize - initialSize;
				assertEquals(1,sizeDifference);
			} else {
				int initialSize = implementation.getGame().getTeamSize();
				implementation.buy(athletes.get(0),positions[i]);
				int finalSize = implementation.getGame().getTeamSize();
				int sizeDifference = finalSize - initialSize;
				assertEquals(0,sizeDifference);
			}
		}
	}
	
	/**
     * Test case for the buy() and sell() methods combined.
     * Ensures that the buy and sell methods maintain the team size.
     */
	@Test
	void testBuySell() {
		implementation.getGame().increaseBalance(10000000);
		String[] positions = {"SEEKER", "KEEPER", "BEATER", "BEATER", "CHASER", "CHASER", "CHASER"};
		for (int i=0;i<positions.length;i++) {
			
			int initialSize = implementation.getGame().getTeamSize();
			implementation.sell(0,2,implementation.getGame().getTeamMember(0).getPosition());
			int prelimSize = implementation.getGame().getTeamSize();
			int initialDifference = initialSize - prelimSize;
			assertEquals(1, initialDifference);
			
			implementation.buy(athletes.get(0),positions[i]);
			int finalSize = implementation.getGame().getTeamSize();
			int finalDifference = initialSize - finalSize;
			assertEquals(0, finalDifference);
		}
	}
	
	/**
     * Test case for the specialTraining() method.
     * Ensures that the specialTraining method updates the athlete's stamina and stats correctly.
     */
	@Test
	void testSpecialTraining() {
		int prevOffence = implementation.getGame().getTeamMember(0).getOffence();
		int prevDefence = implementation.getGame().getTeamMember(0).getDefence();
		
		implementation.specialTraining(0, "CHASER");
		for (int i=0; i<implementation.getGame().getTeamSize(); i++) {
			int athleteStamina = implementation.getGame().getTeam().get(i).getStamina();
			assertEquals(100, athleteStamina);
		}
		
		for (int i=0; i<implementation.getGame().getReserveSize(); i++) {
			int athleteStamina = implementation.getGame().getReserves().get(i).getStamina();
			assertEquals(100, athleteStamina);
		}
		int newOffence = implementation.getGame().getTeamMember(0).getOffence();
		int newDefence = implementation.getGame().getTeamMember(0).getDefence();
		
		int offenceDiff = newOffence - prevOffence;
		int defenceDiff = newDefence - prevDefence;
		
		if (10 - prevDefence < 4) {
			assertEquals(10-prevDefence, defenceDiff);
		} else {
			assertEquals(4, defenceDiff);
		}
		
		if (10 - prevOffence < 4) {
			assertEquals(10-prevOffence, offenceDiff);
		} else {
			assertEquals(4, offenceDiff);
		}
	}
	
}
