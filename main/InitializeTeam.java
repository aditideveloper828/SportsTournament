package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.*;

public class InitializeTeam {

	private JFrame frame;
	private ScreenManager manager;
	private ArrayList<Athlete> chosen;

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
		ArrayList<Athlete> options = manager.getImplementation().getAthleteOptions(true);
		Athlete[] values = new Athlete[14];
		for (int i = 0; i < 14; i++) {
			values[i] = options.get(i);
		}
		
		JLabel buyTeamLbl = new JLabel("Make Your Team");
		buyTeamLbl.setBounds(198, 18, 284, 36);
		buyTeamLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		buyTeamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(buyTeamLbl);
		
		JComboBox<Athlete> selectSeekerDrpdwn = new JComboBox<Athlete>();
		selectSeekerDrpdwn.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectSeekerDrpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectSeekerDrpdwn.setMaximumRowCount(20);
		selectSeekerDrpdwn.setBounds(109, 95, 496, 27);
		frame.getContentPane().add(selectSeekerDrpdwn);
		
		JComboBox<Athlete> selectBeaterDrpdwn1 = new JComboBox<Athlete>();
		selectBeaterDrpdwn1.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectBeaterDrpdwn1.setMaximumRowCount(20);
		selectBeaterDrpdwn1.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectBeaterDrpdwn1.setBounds(109, 132, 496, 27);
		frame.getContentPane().add(selectBeaterDrpdwn1);
		
		JComboBox<Athlete> selectBeaterDrpdwn2 = new JComboBox<Athlete>();
		selectBeaterDrpdwn2.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectBeaterDrpdwn2.setMaximumRowCount(20);
		selectBeaterDrpdwn2.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectBeaterDrpdwn2.setBounds(109, 171, 496, 27);
		frame.getContentPane().add(selectBeaterDrpdwn2);
		
		JComboBox<Athlete> selectChaserDrpdwn1 = new JComboBox<Athlete>();
		selectChaserDrpdwn1.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectChaserDrpdwn1.setMaximumRowCount(20);
		selectChaserDrpdwn1.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectChaserDrpdwn1.setBounds(109, 208, 496, 27);
		frame.getContentPane().add(selectChaserDrpdwn1);
		
		JComboBox<Athlete> selectChaserDrpdwn2 = new JComboBox<Athlete>();
		selectChaserDrpdwn2.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectChaserDrpdwn2.setMaximumRowCount(20);
		selectChaserDrpdwn2.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectChaserDrpdwn2.setBounds(109, 250, 496, 27);
		frame.getContentPane().add(selectChaserDrpdwn2);
		
		JComboBox<Athlete> selectChaserDrpdwn3 = new JComboBox<Athlete>();
		selectChaserDrpdwn3.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectChaserDrpdwn3.setMaximumRowCount(20);
		selectChaserDrpdwn3.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectChaserDrpdwn3.setBounds(109, 285, 496, 27);
		frame.getContentPane().add(selectChaserDrpdwn3);
		
		JComboBox<Athlete> selectKeeperDrpdwn = new JComboBox<Athlete>();
		selectKeeperDrpdwn.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectKeeperDrpdwn.setMaximumRowCount(20);
		selectKeeperDrpdwn.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectKeeperDrpdwn.setBounds(109, 322, 496, 27);
		frame.getContentPane().add(selectKeeperDrpdwn);
		
		JComboBox<Athlete> selectReserveDrpdwn = new JComboBox<Athlete>();
		selectReserveDrpdwn.setModel(new DefaultComboBoxModel<Athlete>(values));
		selectReserveDrpdwn.setMaximumRowCount(20);
		selectReserveDrpdwn.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectReserveDrpdwn.setBounds(109, 359, 496, 27);
		frame.getContentPane().add(selectReserveDrpdwn);
		
		
		JButton makeTeam = new JButton("Let's Play!");
		makeTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosen = new ArrayList<Athlete>();
				Athlete choice = (Athlete) selectSeekerDrpdwn.getItemAt(selectSeekerDrpdwn.getSelectedIndex());
				choice.setPosition("SEEKER");
				chosen.add(choice);
				choice = (Athlete) selectBeaterDrpdwn1.getItemAt(selectBeaterDrpdwn1.getSelectedIndex());
				choice.setPosition("BEATER");
				chosen.add(choice);
				choice = (Athlete) selectBeaterDrpdwn2.getItemAt(selectBeaterDrpdwn2.getSelectedIndex());
				choice.setPosition("BEATER");
				chosen.add(choice);
				choice = (Athlete) selectChaserDrpdwn1.getItemAt(selectChaserDrpdwn1.getSelectedIndex());
				choice.setPosition("CHASER");
				chosen.add(choice);
				choice = (Athlete) selectChaserDrpdwn2.getItemAt(selectChaserDrpdwn2.getSelectedIndex());
				choice.setPosition("CHASER");
				chosen.add(choice);
				choice = (Athlete) selectChaserDrpdwn3.getItemAt(selectChaserDrpdwn3.getSelectedIndex());
				choice.setPosition("CHASER");
				chosen.add(choice);
				choice = (Athlete) selectKeeperDrpdwn.getItemAt(selectKeeperDrpdwn.getSelectedIndex());
				choice.setPosition("KEEPER");
				chosen.add(choice);
				choice = (Athlete) selectReserveDrpdwn.getItemAt(selectReserveDrpdwn.getSelectedIndex());
				choice.setPosition("RESERVE");
				chosen.add(choice);
				Set<Athlete> setChosen = new LinkedHashSet<Athlete>(chosen);
				if (setChosen.size() == 8) {
					manager.getImplementation().initializeTeam(chosen);
					finishedWindow();
				}
				else {
					JOptionPane.showMessageDialog(frame, "You need to select 8 different team members to play!");
				}
			}
		});
		
		makeTeam.setBounds(476, 424, 142, 29);
		frame.getContentPane().add(makeTeam);
		
		
		JLabel seekerLbl = new JLabel("SEEKER: ");
		seekerLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		seekerLbl.setBounds(30, 98, 135, 19);
		frame.getContentPane().add(seekerLbl);
		
		JLabel beater2Lbl = new JLabel("BEATER: ");
		beater2Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		beater2Lbl.setBounds(30, 174, 162, 19);
		frame.getContentPane().add(beater2Lbl);
		
		JLabel beater1Lbl = new JLabel("BEATER: ");
		beater1Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		beater1Lbl.setBounds(30, 136, 135, 19);
		frame.getContentPane().add(beater1Lbl);
		
		JLabel chaser1Lbl = new JLabel("CHASER: ");
		chaser1Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chaser1Lbl.setBounds(30, 211, 193, 19);
		frame.getContentPane().add(chaser1Lbl);
		
		JLabel chaser2Lbl = new JLabel("CHASER: ");
		chaser2Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chaser2Lbl.setBounds(30, 253, 193, 19);
		frame.getContentPane().add(chaser2Lbl);
		
		JLabel chaser3Lbl = new JLabel("CHASER:");
		chaser3Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chaser3Lbl.setBounds(30, 288, 204, 19);
		frame.getContentPane().add(chaser3Lbl);
		
		JLabel keeperLbl = new JLabel("KEEPER: ");
		keeperLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		keeperLbl.setBounds(30, 325, 204, 19);
		frame.getContentPane().add(keeperLbl);
		
		JLabel reserveLb = new JLabel("RESERVE: ");
		reserveLb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reserveLb.setBounds(30, 362, 204, 19);
		frame.getContentPane().add(reserveLb);
		
		
		JLabel lblNewLabel = new JLabel("An Athlete may only have one position assigned to them");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(30, 64, 284, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
	
	public void finishedWindow() {
		manager.closeInitializeTeamScreen(this);
	}
}
