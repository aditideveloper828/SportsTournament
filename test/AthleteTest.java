/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Athlete;
import main.FileRead;
import main.Item;

/**
 * The AthleteTest class initialises tests for the Athlete class to ensure 
 * that the methods are working correctly
 * 
 * @author Aditi
 * @author imogenkeeling
 *
 */
class AthleteTest {
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

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link main.Athlete#staminaDecrease()}.
	 */
	@Test
	void testStaminaDecrease() {
		int prev_stamina = athletes.get(0).getStamina();
		athletes.get(0).staminaDecrease();
		int new_stamina = athletes.get(0).getStamina();
		int difference = prev_stamina - new_stamina;
		assertEquals(20, difference);

	}
	
	/*
	 * Test method for {@link main.Athlete#statIncrease()}.
	 * Ensures that the offence and defence rating of the 
	 * Athlete is increased by 1 when the method is called
	 */
	@Test
	void testStatIncrease() {
		int prev_offence = athletes.get(0).getOffence();
		int prev_defence = athletes.get(0).getDefence();
		athletes.get(0).statIncrease();
		int new_offence = athletes.get(0).getOffence();
		int new_defence = athletes.get(0).getDefence();
		int offence_diff = new_offence - prev_offence;
		int defence_diff = new_defence - prev_defence;
		assertEquals(1, offence_diff, defence_diff);
	}
	
	/*
	 * Test method for {@link main.Athlete#staminaRefill()}.
	 * Ensures that the current_staminais increased to 100 when 
	 * staminaRefill is called
	 */
	@Test
	void testStaminaRefill() {
		athletes.get(0).staminaRefill();
		int new_stamina = athletes.get(0).getStamina();
		assertEquals(100, new_stamina);
	}
	
	/*
	 * Test method for {@link main.Athlete#injured()}
	 * Ensures that when an athlete's stamina is reduced to zero, 
	 * they are considered to be injured.
	 */
	@Test
	void testInjury() {
		// decreasing the stamina 5 times so that the currentStamina should be equal to 0
		for (int i=0; i<5; i++) {
			athletes.get(0).staminaDecrease();
		}
		int currentStamina  = athletes.get(0).getStamina();
		assertEquals(0, currentStamina);
		boolean injuryStatus = athletes.get(0).injured();
		assertTrue(injuryStatus);
	}

	/*
	 * Test method for {@link main.Athlete#limitor()}
	 * Decreasing the stamina so that it will become a negative number.
	 * The limitor method should correct this to take it back to 0.
	 */
	@Test
	void testLimitor() {
		// decreasing the stamina 6 times so that the currentStamina becomes -20
		for (int i=0; i<6; i++) {
			athletes.get(0).staminaDecrease();
		}
		int currentStamina = athletes.get(0).getStamina();
		assertEquals(0, currentStamina);
	}
}
