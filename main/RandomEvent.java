package SetUp;

import java.util.*;

public class RandomEvent {
	// states of random events set to False
	static boolean injury = false;
	static boolean sickness = false;
	static boolean contractTerminated = false;
	
	// each method generates a random number between 0-100. 
	// If the number is above 80 (inclusive), the random event
	// will become true. But this random event will not necessarily
	// be called.
	// I assume each event will go back to false every time the class
	// is called for each individual athlete?
	static void randomInjury() {
		Random rand = new Random();
		int myRandProb = rand.nextInt(100);
		// test: System.out.println(myRandProb);
		if (myRandProb>= 80) {
			injury = true;
		} else {
			injury = false;
		}
	}
	
	static void randomSickness() {
		Random rand = new Random();
		int myRandProb = rand.nextInt(100);
		// test: System.out.println(myRandProb);
		if (myRandProb>= 80) {
			sickness = true;
		} else {
			sickness = false;
		}
	}
	
	static void randomTermination() {
		Random rand = new Random();
		int myRandProb = rand.nextInt(100);
		// test: System.out.println(myRandProb);
		if (myRandProb>= 80) {
			contractTerminated = true;
		} else {
			contractTerminated = false;
		}
	}
	
	public static void main(String[] args) {
		// create an array List that holds all of the random event variables
		ArrayList<Boolean> events = new ArrayList<Boolean>();
		events.add(injury);
		events.add(sickness);
		events.add(contractTerminated);
		
		// calls a random variable between 0 and the size of the array list (exclusive)
		Random event = new Random();
		int myRandEvent = event.nextInt(events.size());
		// test: System.out.println(myRandEvent);
		// prints the state of the variable in that position of the array.
		System.out.println(events.get(myRandEvent));
		
		// test: randomInjury();
		// test: randomSickness();
		// test: randomTermination();
	}
	
}
