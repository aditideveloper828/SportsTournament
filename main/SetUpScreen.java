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
		teamNameInput.setBounds(181, 112, 227, 35);
		frame.getContentPane().add(teamNameInput);
		teamNameInput.setColumns(10);
		
		JLabel seasonDurationLbl = new JLabel("Season Duration: ");
		seasonDurationLbl.setBounds(35, 173, 139, 27);
		seasonDurationLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(seasonDurationLbl);
		
		JSlider seasonSlider = new JSlider();
		seasonSlider.setMajorTickSpacing(1);
		seasonSlider.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		seasonSlider.setValue(5);
		seasonSlider.setSnapToTicks(true);
		seasonSlider.setBounds(181, 171, 227, 41);
		seasonSlider.setPaintTicks(true);
		seasonSlider.setPaintLabels(true);
		seasonSlider.setMinorTickSpacing(1);
		seasonSlider.setMinimum(5);
		seasonSlider.setMaximum(15);
		frame.getContentPane().add(seasonSlider);
		
		JRadioButton easyRdBtn = new JRadioButton("Easy");
		easyRdBtn.setSelected(true);
		easyRdBtn.setBounds(181, 234, 70, 23);
		frame.getContentPane().add(easyRdBtn);
		
		JRadioButton hardRdBtn = new JRadioButton("Hard");
		hardRdBtn.setBounds(253, 234, 70, 23);
		frame.getContentPane().add(hardRdBtn);
		
		ButtonGroup G1 = new ButtonGroup();
		G1.add(easyRdBtn);
		G1.add(hardRdBtn);
		
		JLabel difficultyLbl = new JLabel("Difficulty: ");
		difficultyLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		difficultyLbl.setBounds(93, 232, 81, 27);
		frame.getContentPane().add(difficultyLbl);
		
		JButton createTeamBtn = new JButton("Create Team");
		createTeamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
			}
		});
		createTeamBtn.setBackground(new Color(169, 170, 169));
		createTeamBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		createTeamBtn.setBounds(184, 289, 160, 35);
		frame.getContentPane().add(createTeamBtn);
		
	}
	
	public void finishedWindow() {
		manager.closeSetUpScreen(this);
	}
}
