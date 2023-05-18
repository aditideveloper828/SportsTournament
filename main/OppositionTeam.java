 package main;

import java.util.*;

public class OppositionTeam {
	
	public ArrayList<Athlete> opTeam = new ArrayList<Athlete>();
	public ArrayList<String> opTeamNames= new ArrayList<String>();
	private static PurchasableManager freeAthletes;
	private int selectIdx;
	public String opTeamName;
	
	
	public OppositionTeam(PurchasableManager data) {
		freeAthletes = data;
		opTeam = new ArrayList <Athlete>();
		opTeamNames.add("Stinky Soldiers");
		opTeamNames.add("Blue Bottles");
		opTeamNames.add("Rabbit Runners");
		opTeamNames.add("Wing Warriors");
		opTeamNames.add("Raging Rangers");
		opTeamNames.add("Potter Squatters");
		opTeamNames.add("Snape Shapes");
		opTeamNames.add("Broomful Bunnies");
		opTeamNames.add("Arranged Arrows");
		opTeamNames.add("Smiley Smokers");
		opTeamNames.add("Beautiful Bubbles");
		opTeamNames.add("Lacrosse Lovers");
		opTeamNames.add("Coffee Addicts");
		opTeamNames.add("Neat Freaks");
		opTeamNames.add("Whiz Kids");
		opTeamNames.add("Geek Squad");
		opTeamNames.add("College Dropouts");
		opTeamNames.add("Fire Extinguishers");
		opTeamNames.add("Trailblazers");
		opTeamNames.add("Lethal Weapons");
		createOpTeam();
	}
		
	public void createOpTeam() {
//		PurchasableManager.getAllAthletes();
		int i;
		for (i=0; i<=7; i++) {
			Random randSelect = new Random();
			selectIdx = randSelect.nextInt(freeAthletes.getAllAthletes().size());
			Athlete x = freeAthletes.getAllAthletes().get(i);
			opTeam.add(x);
			freeAthletes.remove(x);
		}
		
	}
	
	public String getOpTeamName() {
		opTeamName = opTeamNames.get(0);
		opTeamNames.remove(0);
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
	
	
	public static void main(String[] args) {
		OppositionTeam newTeam = new OppositionTeam(freeAthletes);
		newTeam.displayOpTeam();
	}
	
}
