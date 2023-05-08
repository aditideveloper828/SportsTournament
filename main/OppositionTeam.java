package main;

import java.util.*;

public class OppositionTeam {
	
	public ArrayList<Athlete> opTeam;
	private PurchasableManager freeAthletes;
	private int selectIdx;
	
	
	public OppositionTeam(PurchasableManager data) {
		freeAthletes = data;
		createOpTeam();
	}
		
	public void createOpTeam() {
//		PurchasableManager.getAllAthletes();
		int i;
		for (i=0; i<=6; i++) {
			Random randSelect = new Random();
			selectIdx = randSelect.nextInt(freeAthletes.getAllAthletes().size());
			opTeam.add(freeAthletes.getAllAthletes().get(i));
		}
		
	}
	
	public ArrayList <Athlete> getOpTeam() {
		return opTeam;
	}
	
}
