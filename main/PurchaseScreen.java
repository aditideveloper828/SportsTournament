package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;

public class PurchaseScreen {

	private JFrame frame;
	
	private static PurchasableManager freeAthletes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseScreen window = new PurchaseScreen(freeAthletes);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PurchaseScreen(PurchasableManager data) {
		freeAthletes = data;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel marketTitle = new JLabel("Market");
		marketTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		marketTitle.setBounds(168, 6, 105, 25);
		frame.getContentPane().add(marketTitle);
		
		JLabel welcomeMarketMsg2 = new JLabel("Here, you can buy and sell Athletes, and purchase power-up items for your team!");
		welcomeMarketMsg2.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		welcomeMarketMsg2.setBounds(6, 30, 438, 16);
		frame.getContentPane().add(welcomeMarketMsg2);
		
		JComboBox buyAthleteDropdown = new JComboBox();
		buyAthleteDropdown.setBounds(16, 80, 141, 27);
		frame.getContentPane().add(buyAthleteDropdown);
		
		JLabel buyAthleteLbl = new JLabel("Athletes on the Market...");
		buyAthleteLbl.setBounds(16, 53, 163, 16);
		frame.getContentPane().add(buyAthleteLbl);
		
		JButton buyAthleteBtn = new JButton("Buy Athlete!");
		buyAthleteBtn.setBounds(16, 237, 117, 29);
		frame.getContentPane().add(buyAthleteBtn);
		
		JTextPane athleteDetailTxt = new JTextPane();
		athleteDetailTxt.setText("Athlete details here");
		athleteDetailTxt.setBounds(16, 119, 141, 105);
		frame.getContentPane().add(athleteDetailTxt);
		
		JLabel itemMarketLbl = new JLabel("Items to buy...");
		itemMarketLbl.setBounds(268, 53, 117, 16);
		frame.getContentPane().add(itemMarketLbl);
		
		JComboBox buyItemsDropdown = new JComboBox();
		buyItemsDropdown.setToolTipText("");
		buyItemsDropdown.setBounds(268, 80, 141, 27);
		frame.getContentPane().add(buyItemsDropdown);
		
		JTextPane itemDetailTxt = new JTextPane();
		itemDetailTxt.setText("item description here");
		itemDetailTxt.setBounds(268, 119, 141, 105);
		frame.getContentPane().add(itemDetailTxt);
		
		JButton buyItemBtn = new JButton("Buy Item!");
		buyItemBtn.setBounds(278, 237, 117, 29);
		frame.getContentPane().add(buyItemBtn);
		
	}
}
