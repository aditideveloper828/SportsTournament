package main;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

/**
 * GUI implementation for picking an opposition team for the next match
 */
public class InitiateMatchScreen {

	private JFrame frame;
	private ScreenManager manager;
	private PurchasableManager data;
	private Interaction implementation;
	private ArrayList<String> names;
	

	/**
	 * Create the application.
	 * 
	 * @param incomingManager calling the screenManager class
	 */
	public InitiateMatchScreen(ScreenManager incomingManager) {
		manager = incomingManager;
		implementation = incomingManager.getImplementation();
		data = implementation.getMarket();
		names = implementation.getOpTeamName();
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Method to dispose of the current screen
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Method to retrieve and return the names of the Opposition Teams
	 * 
	 * @return the names of the opposition team's athletes
	 */
	public ArrayList<String> getNames(){
		return names;
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
		
		@SuppressWarnings("rawtypes")
		JList opTeamList = new JList();
		opTeamList.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		opTeamList.setBounds(334, 169, 274, 170);
		frame.getContentPane().add(opTeamList);
		
		JLabel opTeamLbl = new JLabel("Team Details: ");
		opTeamLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		opTeamLbl.setBounds(334, 141, 149, 16);
		frame.getContentPane().add(opTeamLbl);
		
		OppositionTeam team1 = new OppositionTeam(data, this);
		ArrayList<String> team1String = team1.getInfo();
		JRadioButton team1RdBtn = new JRadioButton(team1.getName());
		team1RdBtn.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
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
		team1RdBtn.setBounds(34, 170, 215, 23);
		frame.getContentPane().add(team1RdBtn);
		
		OppositionTeam team2 = new OppositionTeam(data, this);
		ArrayList<String> team2String = team2.getInfo();
		JRadioButton team2RdBtn = new JRadioButton(team2.getName());
		team2RdBtn.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
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
		team2RdBtn.setBounds(34, 242, 252, 23);
		frame.getContentPane().add(team2RdBtn);
		
		OppositionTeam team3 = new OppositionTeam(data, this);
		ArrayList<String> team3String = team3.getInfo();
		JRadioButton team3RdBtn = new JRadioButton(team3.getName());
		team3RdBtn.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
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
		team3RdBtn.setBounds(34, 205, 215, 23);
		frame.getContentPane().add(team3RdBtn);
		
		ButtonGroup PickTeam = new ButtonGroup();
		PickTeam.add(team1RdBtn);
		PickTeam.add(team2RdBtn);
		PickTeam.add(team3RdBtn);
		
		
		JLabel teamSlctDetaillLbl = new JLabel("Select a team to play against");
		teamSlctDetaillLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		teamSlctDetaillLbl.setBounds(34, 142, 149, 16);
		frame.getContentPane().add(teamSlctDetaillLbl);
		
		JButton playGameBtn = new JButton("PLAY GAME");
		playGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team1RdBtn.isSelected()) {
					implementation.playGame(team1);
				}
				
				else if (team2RdBtn.isSelected()) {
					implementation.playGame(team2);;
				}
				
				else if (team3RdBtn.isSelected()) {
					implementation.playGame(team3);;
				}
				team1.disposeOpTeam();
				team2.disposeOpTeam();
				team3.disposeOpTeam();
				finishedWindow();
			}
		});
		playGameBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		playGameBtn.setBounds(524, 418, 149, 35);
		frame.getContentPane().add(playGameBtn);
	}
	
	/**
	 * Method to initiate the disposal process of this screen and opening of the following screen.
	 */
	public void finishedWindow() {
		manager.closeInitiateMatchScreen(this);
	}
}
