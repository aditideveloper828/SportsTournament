 package main;

import java.util.*;

/**
 * Represents an opposition team in a match.
 * Manages the creation, retrieval, and disposal of the opposition team.
 * Provides methods to retrieve information about the opposition team.
 * 
 */

public class OppositionTeam {
	
	/**
	 * The ArrayList that stores the opposition team athletes
	 */
	public ArrayList<Athlete> opTeam = new ArrayList<Athlete>();
	
	/**
	 * ArrayList that stores the names of the athletes from the opposition team
	 */
	public ArrayList<String> nameString = new ArrayList<String>();
	private PurchasableManager freeAthletes;
	private InitiateMatchScreen name;
	
	/**
	 * The opposition team's team name
	 */
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
		setName();
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
		return teamName;
	}
	
	/**
	 * Sets the name of the opposition team.
	 *
	 * @return null
	 */
	public void setName() {
		ArrayList<String> names = name.getNames();
		teamName = names.remove(0);
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
