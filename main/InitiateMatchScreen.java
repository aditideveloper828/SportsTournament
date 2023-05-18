package main;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class InitiateMatchScreen {

	private JFrame frame;
	private ScreenManager manager;
	private PurchasableManager data;
	public ArrayList<String> opTeamNames= new ArrayList<String>();
	public String opTeamName;

	/**
	 * Create the application.
	 */
	public InitiateMatchScreen(PurchasableManager incomingData, ScreenManager incomingManager) {
		data = incomingData;
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public String getOpTeamName() {
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
		
		opTeamName = opTeamNames.get(0);
		opTeamNames.remove(0);
		return opTeamName;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel opTeamTitle = new JLabel("Pick your Opposition!");
		opTeamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		opTeamTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		opTeamTitle.setBounds(235, 48, 215, 25);
		frame.getContentPane().add(opTeamTitle);
		
		OppositionTeam team1 = new OppositionTeam(data, this);
		JRadioButton team1RdBtn = new JRadioButton(team1.getName());
		team1RdBtn.setBounds(235, 132, 141, 23);
		frame.getContentPane().add(team1RdBtn);
		
		OppositionTeam team2 = new OppositionTeam(data, this);
		JRadioButton team2RdBtn = new JRadioButton(team2.getName());
		team2RdBtn.setBounds(235, 230, 141, 23);
		frame.getContentPane().add(team2RdBtn);
		
		OppositionTeam team3 = new OppositionTeam(data, this);
		JRadioButton team3RdBtn = new JRadioButton(team3.getName());
		team3RdBtn.setBounds(235, 180, 141, 23);
		frame.getContentPane().add(team3RdBtn);
		
		ButtonGroup PickTeam = new ButtonGroup();
		PickTeam.add(team1RdBtn);
		PickTeam.add(team2RdBtn);
		PickTeam.add(team3RdBtn);

	}
}
