package main;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

public class InitiateMatchScreen {

	private static JFrame frame;
	private ScreenManager manager;
	private PurchasableManager data;
	private GameEnvironment game;
	public ArrayList<String> opTeamNames= new ArrayList<String>();
	public String opTeamName;
	

	/**
	 * Create the application.
	 */
	public InitiateMatchScreen(PurchasableManager incomingData, ScreenManager incomingManager, GameEnvironment incomingGame) {
		game = incomingGame;
		data = incomingData;
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public static void closeWindow() {
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
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.BOLD, 20));
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel opTeamTitle = new JLabel("Pick your Opposition!");
		opTeamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		opTeamTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		opTeamTitle.setBounds(235, 48, 215, 25);
		frame.getContentPane().add(opTeamTitle);
		
		JList opTeamList = new JList();
		opTeamList.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		opTeamList.setBounds(334, 169, 215, 170);
		frame.getContentPane().add(opTeamList);
		
		JLabel opTeamLbl = new JLabel("Team Details: ");
		opTeamLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		opTeamLbl.setBounds(334, 141, 149, 16);
		frame.getContentPane().add(opTeamLbl);
		
		OppositionTeam team1 = new OppositionTeam(data, this);
		ArrayList<String> team1String = team1.getNames();
		JRadioButton team1RdBtn = new JRadioButton(team1.getName());
		team1RdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opTeamList.setModel(new AbstractListModel() {
					public int getSize() {
						return team1String.size();
					}
					public Object getElementAt(int index) {
						return team1String.get(index);
					}
				});
			}
		});
		team1RdBtn.setBounds(34, 170, 141, 23);
		frame.getContentPane().add(team1RdBtn);
		
		OppositionTeam team2 = new OppositionTeam(data, this);
		ArrayList<String> team2String = team2.getNames();
		JRadioButton team2RdBtn = new JRadioButton(team2.getName());
		team2RdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opTeamList.setModel(new AbstractListModel() {
					public int getSize() {
						return team2String.size();
					}
					public Object getElementAt(int index) {
						return team2String.get(index);
					}
				});
			}
		});
		team2RdBtn.setBounds(34, 240, 141, 23);
		frame.getContentPane().add(team2RdBtn);
		
		OppositionTeam team3 = new OppositionTeam(data, this);
		ArrayList<String> team3String = team3.getNames();
		JRadioButton team3RdBtn = new JRadioButton(team3.getName());
		team3RdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opTeamList.setModel(new AbstractListModel() {
					public int getSize() {
						return team3String.size();
					}
					public Object getElementAt(int index) {
						return team3String.get(index);
					}
				});
			}
		});
		team3RdBtn.setBounds(34, 205, 141, 23);
		frame.getContentPane().add(team3RdBtn);
		
		ButtonGroup PickTeam = new ButtonGroup();
		PickTeam.add(team1RdBtn);
		PickTeam.add(team2RdBtn);
		PickTeam.add(team3RdBtn);
		
		JButton backBtn = new JButton("<BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.goBack(ScreenCase.CHOOSEOPTEAMSCREEN);
			}
		});
		backBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		backBtn.setBounds(6, 6, 69, 29);
		frame.getContentPane().add(backBtn);
		
		JLabel teamSlctDetaillLbl = new JLabel("Select a team to play against");
		teamSlctDetaillLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		teamSlctDetaillLbl.setBounds(34, 142, 149, 16);
		frame.getContentPane().add(teamSlctDetaillLbl);
		
		JButton playGameBtn = new JButton("PLAY GAME");
		playGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team1RdBtn.isSelected()) {
					Match playMatch = new Match(game, team1);
				}
				
				else if (team2RdBtn.isSelected()) {
					Match playMatch = new Match(game, team2);
				}
				
				else if (team3RdBtn.isSelected()) {
					Match playMatch = new Match(game, team3);
				}
				
				finishedWindow();
			}
		});
		playGameBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		playGameBtn.setBounds(524, 418, 149, 35);
		frame.getContentPane().add(playGameBtn);
	}
	
	public void finishedWindow() {
		manager.closeInitiateMatchScreen();
	}
}
