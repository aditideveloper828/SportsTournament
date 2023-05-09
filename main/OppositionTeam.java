package main;

import java.util.*;

public class OppositionTeam {
	
	public ArrayList<Athlete> opTeam;
	private PurchasableManager freeAthletes;
	private int selectIdx;
	public String opTeamName;
	
	
	public OppositionTeam(PurchasableManager data, String name) {
		opTeamName = name;
		freeAthletes = data;
		opTeam = new ArrayList <Athlete>();
		createOpTeam();
	}
		
	public void createOpTeam() {
//		PurchasableManager.getAllAthletes();
		int i;
		for (i=0; i<=6; i++) {
			Random randSelect = new Random();
			selectIdx = randSelect.nextInt(freeAthletes.getAllAthletes().size());
			Athlete x = freeAthletes.getAllAthletes().get(i);
			opTeam.add(x);
			freeAthletes.remove(x);
		}
		
	}
	
	public String getOpTeamName() {
		return opTeamName;
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
