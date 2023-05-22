package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * GUI implementation of the "club" where a user can swap athlete positions, 
 * and use items on the athletes to improve their stats
 */
public class ClubScreen {

	private JFrame frame;
	private ScreenManager manager;
	private Interaction implementation;
	private GameEnvironment game;
	private int selectedTeamMember = -1;
	private int selectedReserve = -1;
	private int lastSelected = -1;

	/**
	 * Create the application.
	 * 
	 * @param incomingManager calling the screenManager class
	 */
	public ClubScreen(ScreenManager incomingManager) {
		manager = incomingManager;
		implementation = incomingManager.getImplementation();
		game = implementation.getGame();
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Method to dispose of the current screen
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ArrayList<Athlete> team = game.getTeam();
		ArrayList<Athlete> reserves = game.getReserves();
		ArrayList<Item> itemOptions = implementation.getBoughtItems();
		Item[] items = new Item[0];
		if (itemOptions.size() > 0) {
			items = new Item[itemOptions.size()];
			for (int i = 0; i < itemOptions.size(); i++) {
				items[i] = itemOptions.get(i);
			}
		}
		
		
		
		JLabel clubTitle = new JLabel("Welcome to the Club!");
		clubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clubTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		clubTitle.setBounds(226, 31, 219, 36);
		frame.getContentPane().add(clubTitle);
		
		JButton homeBtn = new JButton("HOME");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.goHome();
				closeWindow();
			}
		});
		homeBtn.setBounds(6, 6, 95, 29);
		frame.getContentPane().add(homeBtn);
		
		JLabel teamNameLbl = new JLabel(game.getTeamName());
		teamNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		teamNameLbl.setBounds(226, 60, 219, 29);
		frame.getContentPane().add(teamNameLbl);
		
		JLabel currentBalanceLbl = new JLabel("Current Balance: $" + game.getBalance());
		currentBalanceLbl.setBounds(6, 450, 209, 16);
		frame.getContentPane().add(currentBalanceLbl);
		
		JLabel displayTeamLbl = new JLabel("Your Team:");
		displayTeamLbl.setBounds(49, 99, 87, 21);
		frame.getContentPane().add(displayTeamLbl);
		
		JLabel statsLbl = new JLabel("");
		statsLbl.setBounds(394, 224, 181, 143);
		frame.getContentPane().add(statsLbl);
		
		JButton athleteBtn = new JButton("");
		if (team.size() > 0) {
			athleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = team.get(0);
					String description = currentAthlete.getDescription();
					selectedTeamMember = 0;
					lastSelected = 1;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn.setText(team.get(0).getName());
		}
		athleteBtn.setBounds(49, 146, 117, 29);
		frame.getContentPane().add(athleteBtn);
		
		JButton athleteBtn1 = new JButton("");
		if (team.size() > 1) {
			athleteBtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = team.get(1);
					String description = currentAthlete.getDescription();
					selectedTeamMember = 1;
					lastSelected = 1;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn1.setText(team.get(1).getName());
		}
		athleteBtn1.setBounds(176, 146, 117, 29);
		frame.getContentPane().add(athleteBtn1);
		
		JButton athleteBtn7 = new JButton("");
		if (reserves.size() > 0) {
			athleteBtn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = reserves.get(0);
					String description = currentAthlete.getDescription();
					selectedReserve = 0;
					lastSelected = 2;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn7.setText(reserves.get(0).getName());
		}
		athleteBtn7.setBounds(49, 330, 117, 29);
		frame.getContentPane().add(athleteBtn7);
		
		JButton athleteBtn3 = new JButton("");
		if (team.size() > 3) {
			athleteBtn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = team.get(3);
					String description = currentAthlete.getDescription();
					selectedTeamMember = 3;
					lastSelected = 1;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn3.setText(team.get(3).getName());
		}
		athleteBtn3.setBounds(176, 185, 117, 29);
		frame.getContentPane().add(athleteBtn3);
		
		JButton athleteBtn4 = new JButton("");
		if (team.size() > 4) {
			athleteBtn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = team.get(4);
					String description = currentAthlete.getDescription();
					selectedTeamMember = 4;
					lastSelected = 1;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn4.setText(team.get(4).getName());
		}
		athleteBtn4.setBounds(49, 224, 117, 29);
		frame.getContentPane().add(athleteBtn4);
		
		JButton athleteBtn8 = new JButton("");
		if (reserves.size() > 1) {
			athleteBtn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = reserves.get(1);
					String description = currentAthlete.getDescription();
					selectedReserve = 1;
					lastSelected = 2;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn8.setText(reserves.get(1).getName());
		}
		athleteBtn8.setBounds(176, 330, 117, 29);
		frame.getContentPane().add(athleteBtn8);
		
		JButton athleteBtn6 = new JButton("");
		if (team.size() > 6) {
			athleteBtn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = team.get(6);
					String description = currentAthlete.getDescription();
					selectedTeamMember = 6;
					lastSelected = 1;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");				}
			});
			athleteBtn6.setText(team.get(6).getName());
		}
		athleteBtn6.setBounds(114, 271, 117, 29);
		frame.getContentPane().add(athleteBtn6);
		
		JButton athleteBtn5 = new JButton("");
		if (team.size() > 5) {
			athleteBtn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = team.get(5);
					String description = currentAthlete.getDescription();
					selectedTeamMember = 5;
					lastSelected = 1;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn5.setText(team.get(5).getName());
		}
		athleteBtn5.setBounds(176, 224, 117, 29);
		frame.getContentPane().add(athleteBtn5);
		
		JButton athleteBtn2 = new JButton("");
		if (team.size() > 2) {
			athleteBtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = team.get(2);
					String description = currentAthlete.getDescription();
					selectedTeamMember = 2;
					lastSelected = 1;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn2.setText(team.get(2).getName());
		}
		athleteBtn2.setBounds(49, 185, 117, 29);
		frame.getContentPane().add(athleteBtn2);
		
		JButton athleteBtn11 = new JButton("");
		if (reserves.size() > 4) {
			athleteBtn11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = reserves.get(4);
					String description = currentAthlete.getDescription();
					selectedReserve = 4;
					lastSelected = 2;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn11.setText(reserves.get(4).getName());
		}
		athleteBtn11.setBounds(114, 408, 117, 29);
		frame.getContentPane().add(athleteBtn11);
		
		JButton athleteBtn9 = new JButton("");
		if (reserves.size() > 2) {
			athleteBtn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = reserves.get(2);
					String description = currentAthlete.getDescription();
					selectedReserve = 9;
					lastSelected = 2;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn9.setText(reserves.get(2).getName());
		}
		athleteBtn9.setBounds(49, 369, 117, 29);
		frame.getContentPane().add(athleteBtn9);
		
		JLabel lblNewLabel = new JLabel("Click on an athlete to display their statistics");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(59, 125, 246, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton athleteBtn10 = new JButton((String) null);
		if (reserves.size() > 3) {
			athleteBtn10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Athlete currentAthlete = reserves.get(3);
					String description = currentAthlete.getDescription();
					selectedReserve = 3;
					lastSelected = 2;
					statsLbl.setText("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
			});
			athleteBtn10.setText(reserves.get(3).getName());
		}
		athleteBtn10.setBounds(176, 369, 117, 29);
		frame.getContentPane().add(athleteBtn10);
		
		JLabel lblYourReserves = new JLabel("Your Reserves:");
		lblYourReserves.setBounds(49, 307, 107, 21);
		frame.getContentPane().add(lblYourReserves);
		
		JLabel lblSelectAPlayer = new JLabel("Select a player and an item from the dropdown below to use the item.");
		lblSelectAPlayer.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblSelectAPlayer.setBounds(315, 111, 366, 21);
		frame.getContentPane().add(lblSelectAPlayer);
		
		JComboBox<Item> useItemDrpdwn = new JComboBox<Item>();
		useItemDrpdwn.setModel(new DefaultComboBoxModel<Item>(items));
		useItemDrpdwn.setMaximumRowCount(20);
		useItemDrpdwn.setFont(new Font("Dialog", Font.PLAIN, 13));
		useItemDrpdwn.setBounds(321, 148, 355, 27);
		frame.getContentPane().add(useItemDrpdwn);
		
		JButton useItemBtn = new JButton("Use Item");
		useItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemId = useItemDrpdwn.getSelectedIndex();
				if (lastSelected != -1 && itemId != -1) {
					int athleteID = -1;
					if (lastSelected == 1) {
						athleteID = selectedTeamMember;
					}
					else {
						athleteID = selectedReserve;
					}
					game.useItem(itemId, lastSelected, athleteID);
					finishedWindow();
				}
				else {
					JOptionPane.showMessageDialog(frame, "You need to select an athlete and an item to use item on athlete!");
				}
			}
		});
		useItemBtn.setBounds(394, 185, 176, 29);
		frame.getContentPane().add(useItemBtn);
		
		JButton swapAthletesBtn = new JButton("Swap Athlete Positions");
		swapAthletesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedTeamMember != -1 && selectedReserve != -1) {
					game.swap(game.getTeamMember(selectedTeamMember), game.getReserve(selectedReserve));
					finishedWindow();
				}
				else if (selectedReserve != -1 && game.getTeamSize() < 7) {
					implementation.fillPosition(game.getReserve(selectedReserve));
					finishedWindow();
				}
				else {
					JOptionPane.showMessageDialog(frame, "You need to select an active member then a reserve to swap them!");
				}
			}
		});
		swapAthletesBtn.setBounds(518, 437, 176, 29);
		frame.getContentPane().add(swapAthletesBtn);
		
		JLabel lblSelectAnActive = new JLabel("Select an active member, a reserve, then the swap athletes button to swap positions");
		lblSelectAnActive.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblSelectAnActive.setBounds(289, 408, 405, 21);
		frame.getContentPane().add(lblSelectAnActive);
		
		JLabel currentWeeksLbl = new JLabel("Weeks Remaining: " + implementation.remainingWeeks());
		currentWeeksLbl.setHorizontalAlignment(SwingConstants.CENTER);
		currentWeeksLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
		currentWeeksLbl.setBounds(512, 14, 219, 29);
		frame.getContentPane().add(currentWeeksLbl);
		
	}
	
	/**
	 * Method to initiate the disposal process of this screen and opening of the following screen.
	 */
	public void finishedWindow() {
		manager.closeClubScreen(this);
	}
	
}
