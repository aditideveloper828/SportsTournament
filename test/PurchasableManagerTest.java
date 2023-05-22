package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.Athlete;
import main.FileRead;
import main.Interaction;
import main.PurchasableManager;

/**
 * JUnit test class for the PurchasableManager class.
 */
public class PurchasableManagerTest {
	private static Interaction implementation = new Interaction();
	private static ArrayList<Athlete> athletes = implementation.getMarket().getAllAthletes();
	static PurchasableManager market = new PurchasableManager();
	
	/**
     * Sets up the environment before running any test methods.
     */
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
	
	/**
     * Reads athlete data from a file and adds athletes to the market.
     */
	@BeforeAll
	static void manualAthleteArray() {
		FileRead athleteFile = new FileRead("AthleteMarket");
		ArrayList<String> athleteProfiles = athleteFile.getData();
		for (int i = 1; i < athleteProfiles.size(); i++) {
			String[] characterData = athleteProfiles.get(i).split(";",0);
			int [] stats = new int[5];
			for (int j = 0; j < 5; j++){
				stats[j] = Integer.parseInt(characterData[j+2]);
			}
			String name = characterData[0] + " " + characterData[1];
			try {
				market.add(new Athlete(name, stats));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
     * Test case for the minimumContractPrice() method.
     * Ensures that the method returns the minimum contract price from the athlete directory
     */
	@Test
	void testMinimumContractPrice() {
		int manualMinimum = market.getAllAthletes().get(0).getContractPrice();
		for (int i = 1; i < market.getAllAthletes().size(); i++) {
			int price = market.getAllAthletes().get(i).getContractPrice();
			if (manualMinimum > price) {
				manualMinimum = price;
			}
		}
		int minMethod = implementation.getMarket().minimumContractPrice();
		assertEquals(manualMinimum, minMethod);
	}
	
}
