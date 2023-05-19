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
import javax.swing.DefaultComboBoxModel;

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
			athleteNames.add(String.valueOf(athletes.getAllAthletes().get(i).getName()));
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
		
		JComboBox selectSeekerDrpdwn = new JComboBox();
		String[] values = {"hello", "how", "are", "you"};
		selectSeekerDrpdwn.setModel(new DefaultComboBoxModel(new String[] {"hello", "how", "are", "you"}));
		selectSeekerDrpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectSeekerDrpdwn.setMaximumRowCount(20);
		selectSeekerDrpdwn.setBounds(92, 95, 240, 27);
		frame.getContentPane().add(selectSeekerDrpdwn);
		
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
		initialBalanceLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		initialBalanceLbl.setBounds(488, 385, 169, 27);
		frame.getContentPane().add(initialBalanceLbl);
		
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
		
		JLabel reserve1Lbl = new JLabel("RESERVE:");
		reserve1Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reserve1Lbl.setBounds(30, 315, 67, 19);
		frame.getContentPane().add(reserve1Lbl);
		
		JLabel reserve2Lbl = new JLabel("RESERVE:");
		reserve2Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reserve2Lbl.setBounds(30, 346, 67, 19);
		frame.getContentPane().add(reserve2Lbl);
		
		JLabel reserve3Lbl = new JLabel("RESERVE:");
		reserve3Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reserve3Lbl.setBounds(30, 377, 67, 19);
		frame.getContentPane().add(reserve3Lbl);
		
		JLabel reserve4Lbl = new JLabel("RESERVE:");
		reserve4Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reserve4Lbl.setBounds(30, 410, 67, 19);
		frame.getContentPane().add(reserve4Lbl);
		
		JLabel reserve5Lbl = new JLabel("RESERVE:");
		reserve5Lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reserve5Lbl.setBounds(30, 440, 67, 19);
		frame.getContentPane().add(reserve5Lbl);
		
		JComboBox selectBeater1Drpdwn = new JComboBox();
		selectBeater1Drpdwn.setMaximumRowCount(20);
		selectBeater1Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectBeater1Drpdwn.setBounds(92, 127, 240, 27);
		frame.getContentPane().add(selectBeater1Drpdwn);
		
		JComboBox selectBeater2Drpdwn = new JComboBox();
		selectBeater2Drpdwn.setMaximumRowCount(20);
		selectBeater2Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectBeater2Drpdwn.setBounds(92, 158, 240, 27);
		frame.getContentPane().add(selectBeater2Drpdwn);
		
		JComboBox selectChaser1Drpdwn = new JComboBox();
		selectChaser1Drpdwn.setMaximumRowCount(20);
		selectChaser1Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectChaser1Drpdwn.setBounds(92, 189, 240, 27);
		frame.getContentPane().add(selectChaser1Drpdwn);
		
		JComboBox selectChaser2Drpdwn = new JComboBox();
		selectChaser2Drpdwn.setMaximumRowCount(20);
		selectChaser2Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectChaser2Drpdwn.setBounds(92, 220, 240, 27);
		frame.getContentPane().add(selectChaser2Drpdwn);
		
		JComboBox selectChaser3Drpdwn = new JComboBox();
		selectChaser3Drpdwn.setMaximumRowCount(20);
		selectChaser3Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectChaser3Drpdwn.setBounds(92, 251, 240, 27);
		frame.getContentPane().add(selectChaser3Drpdwn);
		
		JComboBox selectKeeperDrpdwn = new JComboBox();
		selectKeeperDrpdwn.setMaximumRowCount(20);
		selectKeeperDrpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectKeeperDrpdwn.setBounds(92, 282, 240, 27);
		frame.getContentPane().add(selectKeeperDrpdwn);
		
		JComboBox selectReserve1Drpdwn = new JComboBox();
		selectReserve1Drpdwn.setMaximumRowCount(20);
		selectReserve1Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectReserve1Drpdwn.setBounds(92, 313, 240, 27);
		frame.getContentPane().add(selectReserve1Drpdwn);
		
		JComboBox selectReserve2Drpdwn = new JComboBox();
		selectReserve2Drpdwn.setMaximumRowCount(20);
		selectReserve2Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectReserve2Drpdwn.setBounds(92, 344, 240, 27);
		frame.getContentPane().add(selectReserve2Drpdwn);
		
		JComboBox selectReserve3Drpdwn = new JComboBox();
		selectReserve3Drpdwn.setMaximumRowCount(20);
		selectReserve3Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectReserve3Drpdwn.setBounds(92, 375, 240, 27);
		frame.getContentPane().add(selectReserve3Drpdwn);
		
		JComboBox selectReserve4Drpdwn = new JComboBox();
		selectReserve4Drpdwn.setMaximumRowCount(20);
		selectReserve4Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectReserve4Drpdwn.setBounds(92, 408, 240, 27);
		frame.getContentPane().add(selectReserve4Drpdwn);
		
		JComboBox selectReserve5Drpdwn = new JComboBox();
		selectReserve5Drpdwn.setMaximumRowCount(20);
		selectReserve5Drpdwn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		selectReserve5Drpdwn.setBounds(92, 438, 240, 27);
		frame.getContentPane().add(selectReserve5Drpdwn);
		
		JLabel lblNewLabel = new JLabel("An Athlete may only have one position assigned to them");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(30, 64, 284, 16);
		frame.getContentPane().add(lblNewLabel);
		
//		JList list = new JList(generateAthleteNames().toArray());
//		list.setBounds(60, 194, 134, 128);
//		frame.getContentPane().add(list);
	}
	
	public void finishedWindow() {
		manager.closeBuyTeamScreen(this);
	}
}
