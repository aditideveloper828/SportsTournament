package main;

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
	private static ScreenManager manager;
	private PurchasableManager freeAthletes;

	/**
	 * Create the application.
	 */
	public PurchaseScreen(PurchasableManager data, ScreenManager incomingManager) {
		freeAthletes = data;
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel marketTitle = new JLabel("Market");
		marketTitle.setBounds(278, 6, 122, 40);
		marketTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(marketTitle);
		
		JLabel welcomeMarketMsg2 = new JLabel("Here, you can buy and sell Athletes, and purchase power-up items for your team!");
		welcomeMarketMsg2.setBounds(81, 58, 519, 16);
		welcomeMarketMsg2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		frame.getContentPane().add(welcomeMarketMsg2);
		
		JComboBox buyAthleteDropdown = new JComboBox();
		buyAthleteDropdown.setBounds(42, 167, 199, 33);
		frame.getContentPane().add(buyAthleteDropdown);
		
		JLabel buyAthleteLbl = new JLabel("Athletes on the Market...");
		buyAthleteLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		buyAthleteLbl.setBounds(42, 138, 215, 17);
		frame.getContentPane().add(buyAthleteLbl);
		
		JButton buyAthleteBtn = new JButton("Buy Athlete!");
		buyAthleteBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		buyAthleteBtn.setBounds(69, 402, 142, 40);
		frame.getContentPane().add(buyAthleteBtn);
		
		JTextPane athleteDetailTxt = new JTextPane();
		athleteDetailTxt.setBounds(42, 219, 199, 152);
		athleteDetailTxt.setText("Athlete details here");
		frame.getContentPane().add(athleteDetailTxt);
		
		JLabel itemMarketLbl = new JLabel("Items to buy...");
		itemMarketLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		itemMarketLbl.setBounds(435, 136, 117, 20);
		frame.getContentPane().add(itemMarketLbl);
		
		JComboBox buyItemsDropdown = new JComboBox();
		buyItemsDropdown.setBounds(435, 163, 199, 40);
		buyItemsDropdown.setToolTipText("");
		frame.getContentPane().add(buyItemsDropdown);
		
		JTextPane itemDetailTxt = new JTextPane();
		itemDetailTxt.setBounds(435, 219, 199, 152);
		itemDetailTxt.setText("item description here");
		frame.getContentPane().add(itemDetailTxt);
		
		JButton buyItemBtn = new JButton("Buy Item!");
		buyItemBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		buyItemBtn.setBounds(466, 402, 130, 40);
		frame.getContentPane().add(buyItemBtn);
		
	}
}
