 package main;

import java.util.*;

public class OppositionTeam {
	
	public ArrayList<Athlete> opTeam = new ArrayList<Athlete>();
	private static PurchasableManager freeAthletes;
	private InitiateMatchScreen name;
	public String teamName;
	
	
	public OppositionTeam(PurchasableManager data, InitiateMatchScreen incomingName) {
		name = incomingName;
		freeAthletes = data;
		opTeam = new ArrayList <Athlete>();
		createOpTeam();
	}
		
	private void createOpTeam() {
//		PurchasableManager.getAllAthletes();
		int i;
		for (i=0; i<7; i++) {
			Athlete x = freeAthletes.getRandAthlete();
			opTeam.add(x);
		}
	}
	
	public String getName() {
		teamName = name.getOpTeamName();
		return teamName;
	}
	
	public void displayOpTeam() {
			
			System.out.println("Active Members: ");
			for (int i = 0; i < opTeam.size(); i++) {
				System.out.println(opTeam.get(i));
			}
			
			
		}
	
	public ArrayList <Athlete> getOpTeam() {
		return opTeam;
	}
	
	public void disposeOpTeam() {
		for (int i = 0; i < opTeam.size(); i++) {
			freeAthletes.add(opTeam.get(i));
		}
		
		
	}
	
}
