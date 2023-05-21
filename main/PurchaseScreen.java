package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PurchaseScreen {

	private JFrame frame;
	private ScreenManager manager;
	private Interaction implementation;
	private String[] POSITIONS = new String[] {"SEEKER", "KEEPER", "BEATER", "CHASER", "RESERVE"};


	/**
	 * Create the application.
	 */
	public PurchaseScreen(ScreenManager incomingManager) {
		manager = incomingManager;
		implementation = manager.getImplementation();
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
		frame.setBounds(100, 100, 813, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ArrayList<Athlete> options = implementation.getAthleteOptions(false);
		Athlete[] athleteBuy = new Athlete[5];
		for (int i = 0; i < 5; i++) {
			athleteBuy[i] = options.get(i);
		}
		
		ArrayList<Item> itemOptions = implementation.getItemOptions();
		Item[] itemBuy = new Item[itemOptions.size()];
		if (itemOptions.size() != 0) {
			for (int i = 0; i < itemOptions.size(); i++) {	
				itemBuy[i] = itemOptions.get(i);
			}
		}
		ArrayList<Athlete> sellAthleteOptions = implementation.getFullTeam();
		Athlete[] athleteSell = new Athlete[sellAthleteOptions.size()];
		for (int i = 0; i < sellAthleteOptions.size(); i++) {
			athleteSell[i] = sellAthleteOptions.get(i);
		}
		ArrayList<Item> itemSellOptions = implementation.getBoughtItems();
		Item[] itemSell = new Item[itemSellOptions.size()];
		if (itemSellOptions.size() != 0) {
			for (int i = 0; i < itemSellOptions.size(); i++) {
				itemSell[i] = itemSellOptions.get(i);
			}
		}
		
		JLabel marketTitle = new JLabel("Market");
		marketTitle.setBounds(348, 6, 122, 40);
		marketTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(marketTitle);

		JLabel welcomeMarketMsg2 = new JLabel("Here, you can buy and sell Athletes, and purchase power-up items for your team!");
		welcomeMarketMsg2.setBounds(177, 77, 519, 16);
		welcomeMarketMsg2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		frame.getContentPane().add(welcomeMarketMsg2);
		
		JComboBox<Athlete> buyAthleteDropdown = new JComboBox<Athlete>();
		buyAthleteDropdown.setModel(new DefaultComboBoxModel<Athlete>(athleteBuy));
		buyAthleteDropdown.setBounds(42, 133, 538, 33);
		buyAthleteDropdown.setMaximumRowCount(20);
		buyAthleteDropdown.setToolTipText("");
		frame.getContentPane().add(buyAthleteDropdown);
		
		JComboBox<String> positionDrpdwn = new JComboBox<String>();
		positionDrpdwn.setModel(new DefaultComboBoxModel<String>(POSITIONS));
		positionDrpdwn.setBounds(590, 133, 199, 33);
		positionDrpdwn.setMaximumRowCount(20);
		frame.getContentPane().add(positionDrpdwn);

		JComboBox<Item> buyItemsDropdown = new JComboBox<Item>();
		buyItemsDropdown.setModel(new DefaultComboBoxModel<Item>(itemBuy));
		buyItemsDropdown.setBounds(42, 244, 538, 33);
		buyItemsDropdown.setMaximumRowCount(20);
		buyItemsDropdown.setToolTipText("");
		frame.getContentPane().add(buyItemsDropdown);
		
		JComboBox<Item> itemSellDrpdwn = new JComboBox<Item>();
		itemSellDrpdwn.setModel(new DefaultComboBoxModel<Item>(itemSell));
		itemSellDrpdwn.setToolTipText("");
		itemSellDrpdwn.setMaximumRowCount(20);
		itemSellDrpdwn.setBounds(42, 440, 538, 33);
		frame.getContentPane().add(itemSellDrpdwn);
		
		
		JComboBox<Athlete> sellDrpdwn = new JComboBox<Athlete>();
		sellDrpdwn.setModel(new DefaultComboBoxModel<Athlete>(athleteSell));
		sellDrpdwn.setMaximumRowCount(20);
		sellDrpdwn.setBounds(42, 329, 538, 33);
		frame.getContentPane().add(sellDrpdwn);
		
		JLabel buyAthleteLbl = new JLabel("Athletes on the Market...");
		buyAthleteLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		buyAthleteLbl.setBounds(42, 103, 193, 17);
		frame.getContentPane().add(buyAthleteLbl);
		
		JButton buyAthleteBtn = new JButton("Buy Athlete!");
		buyAthleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete toBuyAthlete = (Athlete) buyAthleteDropdown.getItemAt(buyAthleteDropdown.getSelectedIndex());
				String selectedPosition = positionDrpdwn.getItemAt(positionDrpdwn.getSelectedIndex());
				JOptionPane.showMessageDialog(frame, implementation.buy(toBuyAthlete, selectedPosition));
				finishedWindow();
			}
		});
		buyAthleteBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		buyAthleteBtn.setBounds(647, 176, 142, 40);
		frame.getContentPane().add(buyAthleteBtn);
		
		JLabel itemMarketLbl = new JLabel("Items to buy...");
		itemMarketLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		itemMarketLbl.setBounds(42, 210, 117, 20);
		frame.getContentPane().add(itemMarketLbl);
		
		JButton buyItemBtn = new JButton("Buy Item!");
		buyItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item toBuyItem = (Item) buyItemsDropdown.getItemAt(buyItemsDropdown.getSelectedIndex());
				JOptionPane.showMessageDialog(frame, implementation.buy(toBuyItem));
				finishedWindow();
			}
		});
		buyItemBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		buyItemBtn.setBounds(647, 237, 142, 40);
		frame.getContentPane().add(buyItemBtn);
		
		JButton homeBtn = new JButton("HOME");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.goHome(ScreenCase.PURCHASESCREEN);
				finishedWindow();
			}
		});
		homeBtn.setBounds(6, 6, 97, 29);
		frame.getContentPane().add(homeBtn);
		
		JLabel currentBalanceLbl = new JLabel("Current Balance: $" + implementation.getGame().getBalance());
		currentBalanceLbl.setBounds(358, 51, 209, 16);
		frame.getContentPane().add(currentBalanceLbl);
		
		JButton sellAthleteBtn = new JButton("Sell Athlete!");
		sellAthleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check how its dealing with reserves
				int toSellAthlete = sellDrpdwn.getSelectedIndex();
				implementation.sell(toSellAthlete , 2, athleteSell[toSellAthlete].getPosition());
				finishedWindow();
			}
		});
		sellAthleteBtn.setFont(new Font("Dialog", Font.PLAIN, 17));
		sellAthleteBtn.setBounds(647, 322, 142, 40);
		frame.getContentPane().add(sellAthleteBtn);
		
		JLabel sellLbl = new JLabel("Athletes you can sell...");
		sellLbl.setFont(new Font("Dialog", Font.PLAIN, 16));
		sellLbl.setBounds(42, 299, 249, 20);
		frame.getContentPane().add(sellLbl);
		
		JLabel sellItemLbl = new JLabel("Items you can sell...");
		sellItemLbl.setFont(new Font("Dialog", Font.PLAIN, 16));
		sellItemLbl.setBounds(42, 399, 281, 20);
		frame.getContentPane().add(sellItemLbl);
		
		JButton sellItemBtn = new JButton("Sell Item!");
		sellItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int toSellItem = itemSellDrpdwn.getSelectedIndex();
				implementation.sell(toSellItem , 1, "");
				finishedWindow();
			}
		});
		sellItemBtn.setFont(new Font("Dialog", Font.PLAIN, 17));
		sellItemBtn.setBounds(647, 433, 142, 40);
		frame.getContentPane().add(sellItemBtn);
		
		JLabel positionLbl = new JLabel("Set position....");
		positionLbl.setFont(new Font("Dialog", Font.PLAIN, 16));
		positionLbl.setBounds(589, 103, 159, 20);
		frame.getContentPane().add(positionLbl);
	}
	
	public void finishedWindow() {
		manager.closePurchaseScreen(this);
	}
}
