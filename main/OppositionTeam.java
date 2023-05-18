package main;

import java.util.*;

public class OppositionTeam {
	
	public ArrayList<Athlete> opTeam = new ArrayList<Athlete>();
	private static PurchasableManager freeAthletes;
	private int selectIdx;
	private InitiateMatchScreen name;
	public String teamName;
	
	
	public OppositionTeam(PurchasableManager data, InitiateMatchScreen incomingName) {
		name = incomingName;
		freeAthletes = data;
		opTeam = new ArrayList <Athlete>();
		createOpTeam();
	}
		
	public void createOpTeam() {
//		PurchasableManager.getAllAthletes();
		int i;
		for (i=0; i<7; i++) {
			Random randSelect = new Random();
			selectIdx = randSelect.nextInt(freeAthletes.getAllAthletes().size());
			Athlete x = freeAthletes.getAllAthletes().get(i);
			opTeam.add(x);
			freeAthletes.remove(x);
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
	
}
