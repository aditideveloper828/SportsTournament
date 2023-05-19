package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JToolBar;

public class SetUpScreen {

	private JFrame frame;
	private static ScreenManager manager;
	private JTextField teamNameInput;
	String dif;
	public int numDif;
	String errorMessageLbl;
	String teamName = "Unoriginal Name";
	public int seasonDuration;
	private static GameEnvironment game;
	

	/**
	 * Create the application.
	 */
	public SetUpScreen(ScreenManager incomingManager) {
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
		frame.getContentPane().setBackground(new Color(170, 170, 170));
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel SetUpTitle = new JLabel("Create Your Team!");
		SetUpTitle.setBounds(198, 35, 295, 27);
		SetUpTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		SetUpTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(SetUpTitle);
		
		JLabel teamNameLbl = new JLabel("Team Name: ");
		teamNameLbl.setBounds(71, 115, 103, 27);
		teamNameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(teamNameLbl);
		
		teamNameInput = new JTextField();
		teamNameInput.setForeground(new Color(82, 82, 82));
		teamNameInput.setText("Default Team");
		teamNameInput.setBounds(181, 112, 227, 35);
		frame.getContentPane().add(teamNameInput);
		teamNameInput.setColumns(10);
		
		JLabel seasonDurationLbl = new JLabel("Season Duration: ");
		seasonDurationLbl.setBounds(35, 249, 139, 27);
		seasonDurationLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(seasonDurationLbl);
		
		JSlider seasonSlider = new JSlider();
		seasonSlider.setMajorTickSpacing(1);
		seasonSlider.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		seasonSlider.setValue(5);
		seasonSlider.setSnapToTicks(true);
		seasonSlider.setBounds(181, 251, 227, 41);
		seasonSlider.setPaintTicks(true);
		seasonSlider.setPaintLabels(true);
		seasonSlider.setMinorTickSpacing(1);
		seasonSlider.setMinimum(5);
		seasonSlider.setMaximum(15);
		frame.getContentPane().add(seasonSlider);
		
		JRadioButton easyRdBtn = new JRadioButton("Easy");
		easyRdBtn.setSelected(true);
		easyRdBtn.setBounds(181, 331, 70, 23);
		frame.getContentPane().add(easyRdBtn);
		
		JRadioButton hardRdBtn = new JRadioButton("Hard");
		hardRdBtn.setBounds(253, 331, 70, 23);
		frame.getContentPane().add(hardRdBtn);
		
		ButtonGroup G1 = new ButtonGroup();
		G1.add(easyRdBtn);
		G1.add(hardRdBtn);
		
		JLabel difficultyLbl = new JLabel("Difficulty: ");
		difficultyLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		difficultyLbl.setBounds(94, 329, 81, 27);
		frame.getContentPane().add(difficultyLbl);
		
		JLabel errorLbl = new JLabel("");
		errorLbl.setForeground(new Color(184, 12, 0));
		errorLbl.setBounds(181, 189, 513, 16);
		frame.getContentPane().add(errorLbl);
		
		JButton createTeamBtn = new JButton("Create Team");
		createTeamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (teamNameInput.getText().length() < 3 || teamNameInput.getText().length() > 15) {
					errorLbl.setText("Error! Your team name must have 3-15 characters");
					throw new IncorrectInput("Error! Your team name must have 3-15 characters");
				}
				
				// create an if statement for special characters in the team name
				
				teamName = teamNameInput.getText();
				seasonDuration = seasonSlider.getValue();
				
				if (easyRdBtn.isSelected()) {
                    dif = "Easy";
                    numDif = 1;
                }
                else if (hardRdBtn.isSelected()) {
                    dif = "Hard";
                    numDif = 2;
                }
				
				finishedWindow();
				game = new GameEnvironment(teamName, seasonDuration);
				game.setUp();
				manager.setGame(game);
			}
		});
		createTeamBtn.setBackground(new Color(169, 170, 169));
		createTeamBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		createTeamBtn.setBounds(181, 391, 160, 35);
		frame.getContentPane().add(createTeamBtn);
		
		JLabel teamNameDescriptionLbl = new JLabel("Choose a team name. The length must be between 3 and 15");
		teamNameDescriptionLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		teamNameDescriptionLbl.setBounds(181, 149, 444, 16);
		frame.getContentPane().add(teamNameDescriptionLbl);
		
		JLabel teamNameDescriptionLbl_1 = new JLabel("characters, and must not include special characters.");
		teamNameDescriptionLbl_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		teamNameDescriptionLbl_1.setBounds(181, 166, 283, 16);
		frame.getContentPane().add(teamNameDescriptionLbl_1);
		
	}
	
	public void finishedWindow() {
		manager.closeSetUpScreen(this);
	}
}
