package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import java.awt.Color;

public class BuyTeamScreen {

	private JFrame frame;
	private static PurchasableManager athletes;
	private static ScreenManager manager;
	private static GameEnvironment game;
	
	
	
	/**
	 * Create the application.
	 */
	public BuyTeamScreen(PurchasableManager data, ScreenManager incomingManager, GameEnvironment incomingGame) {
		game = incomingGame;
		athletes = data;
		manager = incomingManager;
		// manager.setGame(game);
		initialize();
		frame.setVisible(true);
		
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public ArrayList<String> generateAthleteNames() {
		ArrayList<String> athleteNames = new ArrayList<String>();
		for (int i=0; i<athletes.getAllAthletes().size(); i++) {
			athleteNames.add(athletes.getAllAthletes().get(i).getName());
		}
		return athleteNames;
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
		
		JButton Player1 = new JButton("SEEKER");
		Player1.setForeground(new Color(108, 108, 108));
		Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player1.setText("");
			}
		});
		Player1.setBounds(417, 66, 117, 51);
		frame.getContentPane().add(Player1);
		
		JButton Player2 = new JButton("KEEPER");
		Player2.setForeground(new Color(108, 108, 108));
		Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player2.setText("");
			}
		});
		Player2.setBounds(546, 66, 117, 51);
		frame.getContentPane().add(Player2);
		
		JButton Player3 = new JButton("BEATER #1");
		Player3.setForeground(new Color(108, 108, 108));
		Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player3.setText("");
			}
		});
		Player3.setBounds(417, 122, 117, 51);
		frame.getContentPane().add(Player3);
		
		JButton Player4 = new JButton("BEATER #2");
		Player4.setForeground(new Color(108, 108, 108));
		Player4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player4.setText("");
			}
		});
		Player4.setBounds(546, 122, 117, 51);
		frame.getContentPane().add(Player4);
		
		JButton Player5 = new JButton("CHASER #1");
		Player5.setForeground(new Color(108, 108, 108));
		Player5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player5.setText("");
			}
		});
		Player5.setBounds(417, 178, 117, 51);
		frame.getContentPane().add(Player5);
		
		JButton Player6 = new JButton("CHASER #2");
		Player6.setForeground(new Color(108, 108, 108));
		Player6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player6.setText("");
			}
		});
		Player6.setBounds(546, 178, 117, 51);
		frame.getContentPane().add(Player6);
		
		JButton Player7 = new JButton("CHASER #3");
		Player7.setForeground(new Color(108, 108, 108));
		Player7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player7.setText("");
			}
		});
		Player7.setBounds(417, 234, 117, 51);
		frame.getContentPane().add(Player7);
		
		JButton Player8 = new JButton("RESERVE");
		Player8.setForeground(new Color(108, 108, 108));
		Player8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player8.setText("");
			}
		});
		Player8.setBounds(546, 234, 117, 51);
		frame.getContentPane().add(Player8);
		
		JButton Player9 = new JButton("RESERVE");
		Player9.setForeground(new Color(108, 108, 108));
		Player9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player9.setText("");
			}
		});
		Player9.setBounds(417, 288, 117, 51);
		frame.getContentPane().add(Player9);
		
		JButton Player10 = new JButton("RESERVE");
		Player10.setForeground(new Color(108, 108, 108));
		Player10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player10.setText("");
			}
		});
		Player10.setBounds(546, 288, 117, 51);
		frame.getContentPane().add(Player10);
		
		JComboBox selectAthleteDrpdwn = new JComboBox();
		selectAthleteDrpdwn.setToolTipText("");
		selectAthleteDrpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		selectAthleteDrpdwn.setMaximumRowCount(20);
		selectAthleteDrpdwn.setBounds(50, 137, 290, 36);
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
		initialBalanceLbl.setBounds(50, 97, 203, 27);
		frame.getContentPane().add(initialBalanceLbl);
		
		JButton Player11 = new JButton("RESERVE");
		Player11.setForeground(new Color(108, 108, 108));
		Player11.setBounds(488, 347, 117, 51);
		frame.getContentPane().add(Player11);
		
//		JList list = new JList(generateAthleteNames().toArray());
//		list.setBounds(60, 194, 134, 128);
//		frame.getContentPane().add(list);
	}
	
	public void finishedWindow() {
		manager.closeBuyTeamScreen(this);
	}
}
