package main;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class InitiateMatchScreen {

	private JFrame frame;
	private ScreenManager manager;
	private PurchasableManager data;

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
		
		OppositionTeam team1 = new OppositionTeam(data);
		JRadioButton team1RdBtn = new JRadioButton(team1.getOpTeamName());
		team1RdBtn.setBounds(235, 132, 141, 23);
		frame.getContentPane().add(team1RdBtn);
		
		OppositionTeam team2 = new OppositionTeam(data);
		JRadioButton team2RdBtn = new JRadioButton(team2.getOpTeamName());
		team2RdBtn.setBounds(235, 230, 141, 23);
		frame.getContentPane().add(team2RdBtn);
		
		OppositionTeam team3 = new OppositionTeam(data);
		JRadioButton team3RdBtn = new JRadioButton(team3.getOpTeamName());
		team3RdBtn.setBounds(235, 180, 141, 23);
		frame.getContentPane().add(team3RdBtn);
		
		ButtonGroup PickTeam = new ButtonGroup();
		PickTeam.add(team1RdBtn);
		PickTeam.add(team2RdBtn);
		PickTeam.add(team3RdBtn);

	}
}
