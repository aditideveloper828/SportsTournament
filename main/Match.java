package main;

import java.util.*;

/**
 * @author Imogen Keeling
 *
 */

public class Match {
	private ArrayList<Athlete> offence;
	private ArrayList<Athlete> defence;
	private ArrayList<Athlete> seeker;
	private ArrayList<Athlete> opposeOffence;
	private ArrayList<Athlete> opposeDefence;
	private ArrayList<Athlete> opposeSeeker;
	
	public void addDefence(Athlete athlete) {
		defence.add(athlete);
	}
	
	public void addOffence(Athlete athlete) {
		offence.add(athlete);
	}
	
	public void addSeeker(Athlete athlete) {
		seeker.add(athlete);
	}
	
	public ArrayList<Athlete> getOffence() {
		return offence;
	}
	
	public ArrayList<Athlete> getDefence() {
		return defence;
	}
	
	public ArrayList<Athlete> getSeeker() {
		return seeker;
	}
	
	public ArrayList<Athlete> getOpposeOffence() {
		return opposeOffence;
	}
	
	public ArrayList<Athlete> getOpposeDefence() {
		return opposeDefence;
	}
	
	public ArrayList<Athlete> getOpposeSeeker() {
		return opposeSeeker;
	}
	
	public void matchSummary() {
		// printing the summary of the match (which athletes are playing each other)
		int i;
		for (i=0; i<3; i++) {
			System.out.println(defence.get(i) + " is playing " + opposeOffence.get(i));
			System.out.println(offence.get(i) + " is playing " + opposeDefence.get(i));
			/* How do I grab the offence and defence rating of the athletes involved in this match? */
			
		}
		System.out.println(seeker.get(0) + " is playing " + opposeSeeker.get(0));
	}
	
	
	
}
