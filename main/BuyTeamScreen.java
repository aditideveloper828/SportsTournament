package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyTeamScreen {

	private JFrame frame;
	private static PurchasableManager athletes;
	private static ScreenManager manager;
	
	
	
	/**
	 * Create the application.
	 */
	public BuyTeamScreen(PurchasableManager data, ScreenManager incomingManager) {
		athletes = data;
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
		
		JLabel buyTeamLbl = new JLabel("Buy Your Team");
		buyTeamLbl.setBounds(198, 18, 284, 36);
		buyTeamLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		buyTeamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(buyTeamLbl);
		
		JButton Player1 = new JButton("");
		Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player1.setText("");
			}
		});
		Player1.setBounds(417, 95, 117, 51);
		frame.getContentPane().add(Player1);
		
		JButton Player2 = new JButton("");
		Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player2.setText("");
			}
		});
		Player2.setBounds(546, 95, 117, 51);
		frame.getContentPane().add(Player2);
		
		JButton Player3 = new JButton("");
		Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player3.setText("");
			}
		});
		Player3.setBounds(417, 158, 117, 51);
		frame.getContentPane().add(Player3);
		
		JButton Player4 = new JButton("");
		Player4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player4.setText("");
			}
		});
		Player4.setBounds(546, 158, 117, 51);
		frame.getContentPane().add(Player4);
		
		JButton Player5 = new JButton("");
		Player5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player5.setText("");
			}
		});
		Player5.setBounds(417, 221, 117, 51);
		frame.getContentPane().add(Player5);
		
		JButton Player6 = new JButton("");
		Player6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player6.setText("");
			}
		});
		Player6.setBounds(546, 221, 117, 51);
		frame.getContentPane().add(Player6);
		
		JButton Player7 = new JButton("");
		Player7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player7.setText("");
			}
		});
		Player7.setBounds(417, 284, 117, 51);
		frame.getContentPane().add(Player7);
		
		JButton Player8 = new JButton("");
		Player8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player8.setText("");
			}
		});
		Player8.setBounds(546, 284, 117, 51);
		frame.getContentPane().add(Player8);
		
		JButton Player9 = new JButton("");
		Player9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player9.setText("");
			}
		});
		Player9.setBounds(417, 347, 117, 51);
		frame.getContentPane().add(Player9);
		
		JButton Player10 = new JButton("");
		Player10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player10.setText("");
			}
		});
		Player10.setBounds(546, 347, 117, 51);
		frame.getContentPane().add(Player10);
		
		JComboBox selectAthleteDrpdwn = new JComboBox();
		selectAthleteDrpdwn.setToolTipText("");
		selectAthleteDrpdwn.setModel(new DefaultComboBoxModel(new String[] {"Select Athlete..."}));
		
		for (int i=0; i<athletes.getAllAthletes().size(); i++) {
			// Adding the name of the Athlete and their contract price to the dropdown
			selectAthleteDrpdwn.addItem(athletes.getAllAthletes().get(i).getName()+ " " + athletes.getAllAthletes().get(i).getContractPrice());
		}
		selectAthleteDrpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		selectAthleteDrpdwn.setMaximumRowCount(20);
		selectAthleteDrpdwn.setBounds(41, 122, 290, 36);
		frame.getContentPane().add(selectAthleteDrpdwn);
		
		JLabel priceLbl = new JLabel("Total Cost: $");
		priceLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		priceLbl.setBounds(488, 410, 117, 27);
		frame.getContentPane().add(priceLbl);
		
		JButton purchaseTeamBtn = new JButton("Purchase Team!");
		purchaseTeamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		purchaseTeamBtn.setBounds(475, 437, 142, 29);
		frame.getContentPane().add(purchaseTeamBtn);
		
		JLabel initialBalanceLbl = new JLabel("Starting Balance: $750");
		initialBalanceLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		initialBalanceLbl.setBounds(50, 97, 178, 27);
		frame.getContentPane().add(initialBalanceLbl);
	}
	
	public void finishedWindow() {
		manager.closeBuyTeamScreen(this);
	}
}
