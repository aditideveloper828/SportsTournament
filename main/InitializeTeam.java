package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InitializeTeam {

	private JFrame frame;
	private ScreenManager manager;
	private boolean allSelected = false;

	/**
	 * Create the application.
	 */
	public InitializeTeam(ScreenManager incomingManager) {
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
		frame.setBounds(100, 100, 701, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel buyTeamLbl = new JLabel("Make Your Team");
		buyTeamLbl.setBounds(198, 18, 284, 36);
		buyTeamLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		buyTeamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(buyTeamLbl);
		
		JComboBox selectSeekerDrpdwn = new JComboBox();
		String[] values = {"hello", "how", "are", "you"};
		selectSeekerDrpdwn.setModel(new DefaultComboBoxModel(new String[] {"hello", "how", "are", "you"}));
		selectSeekerDrpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectSeekerDrpdwn.setMaximumRowCount(20);
		selectSeekerDrpdwn.setBounds(92, 95, 240, 27);
		frame.getContentPane().add(selectSeekerDrpdwn);
		
		
		JButton makeTeam = new JButton("Let's Play!");
		makeTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (allSelected) {
					finishedWindow();
				}
				else {
					JOptionPane.showMessageDialog(frame, "You need to select 7 team members to play!");
				}
			}
		});
		
		makeTeam.setBounds(475, 437, 142, 29);
		frame.getContentPane().add(makeTeam);
		
		
		JLabel seekerLbl = new JLabel("SEEKER: ");
		seekerLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		seekerLbl.setBounds(30, 98, 67, 19);
		frame.getContentPane().add(seekerLbl);
		
		JLabel beater2Lbl = new JLabel("BEATER: ");
		beater2Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		beater2Lbl.setBounds(30, 160, 67, 19);
		frame.getContentPane().add(beater2Lbl);
		
		JLabel beater1Lbl = new JLabel("BEATER: ");
		beater1Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		beater1Lbl.setBounds(30, 129, 67, 19);
		frame.getContentPane().add(beater1Lbl);
		
		JLabel chaser1Lbl = new JLabel("CHASER: ");
		chaser1Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chaser1Lbl.setBounds(30, 191, 67, 19);
		frame.getContentPane().add(chaser1Lbl);
		
		JLabel chaser2Lbl = new JLabel("CHASER: ");
		chaser2Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chaser2Lbl.setBounds(30, 222, 67, 19);
		frame.getContentPane().add(chaser2Lbl);
		
		JLabel chaser3Lbl = new JLabel("CHASER:");
		chaser3Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chaser3Lbl.setBounds(30, 253, 67, 19);
		frame.getContentPane().add(chaser3Lbl);
		
		JLabel keeperLbl = new JLabel("KEEPER: ");
		keeperLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		keeperLbl.setBounds(30, 284, 67, 19);
		frame.getContentPane().add(keeperLbl);
		
		JLabel lblNewLabel = new JLabel("An Athlete may only have one position assigned to them");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(30, 64, 284, 16);
		frame.getContentPane().add(lblNewLabel);
		
	}
	
	public void finishedWindow() {
		manager.closeInitializeTeamScreen(this);
	}

}
