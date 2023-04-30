package main;

import java.util.ArrayList;

public class OppositionTeam {
	
	private ArrayList<Athlete> team;
	
	
	public void addOpTeamMember(Athlete athlete) {
		team.add(athlete);
	}
	
	public ArrayList<Athlete> getOpTeam() {
		return team;
	}
}
