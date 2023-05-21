 package main;

import java.util.*;

/*
 * Unused Methods:
 * 
 * public void displayOpTeam() {
		System.out.println("Active Members: ");
		for (int i = 0; i < opTeam.size(); i++) {
			System.out.println(opTeam.get(i));
		}
	}
 */

/**
 * Represents an opposition team in a match.
 * Manages the creation, retrieval, and disposal of the opposition team.
 * Provides methods to retrieve information about the opposition team.
 * 
 */

public class OppositionTeam {
	
	public ArrayList<Athlete> opTeam = new ArrayList<Athlete>();
	public ArrayList<String> nameString = new ArrayList<String>();
	private static PurchasableManager freeAthletes;
	private InitiateMatchScreen name;
	public String teamName;
	
	/**
	 * Constructs an OppositionTeam object with the given PurchasableManager and InitiateMatchScreen.
	 *
	 * @param data the PurchasableManager object
	 * @param incomingName the InitiateMatchScreen object
	 */
	public OppositionTeam(PurchasableManager data, InitiateMatchScreen incomingName) {
		name = incomingName;
		freeAthletes = data;
		opTeam = new ArrayList <Athlete>();
		createOpTeam();
	}
	
	/**
	 * Creates the opposition team by randomly selecting athletes from the PurchasableManager.
	 */
	private void createOpTeam() {
		int i;
		for (i=0; i<7; i++) {
			Athlete x = freeAthletes.getRandAthlete();
			opTeam.add(x);
		}
	}
	
	/**
	 * Retrieves the names of the athletes in the opposition team.
	 *
	 * @return the list of athlete names
	 */
	public ArrayList<String> getInfo() {
		for (int i=0; i < opTeam.size(); i++) {
			String details = opTeam.get(i).getName()+", Offence: "+opTeam.get(i).getOffence()+" Defence: "+opTeam.get(i).getDefence();
			nameString.add(details);
		}
		return nameString;
	}
	
	/**
	 * Retrieves the name of the opposition team.
	 *
	 * @return the name of the opposition team
	 */
	public String getName() {
		ArrayList<String> names = name.getNames();
		teamName = names.remove(0);
		return teamName;
	}
	
	/**
	 * Retrieves the opposition team as an ArrayList of Athlete objects.
	 *
	 * @return the opposition team
	 */
	public ArrayList <Athlete> getOpTeam() {
		return opTeam;
	}
	
	/**
	 * Disposes the opposition team by adding the athletes back to the PurchasableManager.
	 */
	public void disposeOpTeam() {
		for (int i = 0; i < opTeam.size(); i++) {
			freeAthletes.add(opTeam.get(i));
		}
	}

}
