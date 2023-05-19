package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ClubScreen {

	private static JFrame frame;
	private static PurchasableManager data;
	private static ScreenManager manager;
	private static GameEnvironment game;

	/**
	 * Create the application.
	 */
	public ClubScreen(PurchasableManager incomingData, GameEnvironment incomingGame, ScreenManager incomingManager) {
		game = incomingGame;
		data = incomingData;
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public static void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel clubTitle = new JLabel("Welcome to the Club!");
		clubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clubTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		clubTitle.setBounds(226, 31, 219, 36);
		frame.getContentPane().add(clubTitle);
		
		JButton homeBtn = new JButton("HOME");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.goHome(ScreenCase.CLUBSCREEN);
			}
		});
		homeBtn.setBounds(6, 6, 69, 29);
		frame.getContentPane().add(homeBtn);
		
		JLabel teamNameLbl = new JLabel(game.getTeamName());
		teamNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		teamNameLbl.setBounds(226, 79, 219, 29);
		frame.getContentPane().add(teamNameLbl);
		
		JLabel currentBalanceLbl = new JLabel("Current Balance: $" + game.getBalance());
		currentBalanceLbl.setBounds(6, 450, 209, 16);
		frame.getContentPane().add(currentBalanceLbl);
		
		JLabel displayTeamLbl = new JLabel("Your Team:");
		displayTeamLbl.setBounds(55, 120, 87, 21);
		frame.getContentPane().add(displayTeamLbl);
		
		JLabel athleteNameLbl = new JLabel("");
		athleteNameLbl.setBounds(415, 174, 181, 16);
		frame.getContentPane().add(athleteNameLbl);
		
		JLabel offenceLbl = new JLabel("");
		offenceLbl.setBounds(415, 230, 181, 16);
		frame.getContentPane().add(offenceLbl);
		
		JLabel staminaLbl = new JLabel("");
		staminaLbl.setBounds(415, 202, 181, 16);
		frame.getContentPane().add(staminaLbl);
		
		JLabel defenceLbl = new JLabel("");
		defenceLbl.setBounds(415, 256, 181, 16);
		frame.getContentPane().add(defenceLbl);
		
		JLabel positionLbl = new JLabel("");
		positionLbl.setBounds(415, 284, 181, 16);
		frame.getContentPane().add(positionLbl);
		
		JLabel healthLbl = new JLabel("");
		healthLbl.setBounds(415, 312, 181, 16);
		frame.getContentPane().add(healthLbl);
		
		JButton athleteBtn = new JButton("");
		athleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getTeam().get(0);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: " + currentAthlete.getPosition());
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn.setBounds(49, 169, 117, 29);
		athleteBtn.setText(game.getTeam().get(0).getName());
		frame.getContentPane().add(athleteBtn);
		
		JButton athleteBtn_1 = new JButton("");
		athleteBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getTeam().get(1);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: " + currentAthlete.getPosition());
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_1.setBounds(178, 169, 117, 29);
		athleteBtn_1.setText(game.getTeam().get(1).getName());
		frame.getContentPane().add(athleteBtn_1);
		
		JButton athleteBtn_2 = new JButton("");
		athleteBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getTeam().get(2);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: " + currentAthlete.getPosition());
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_2.setBounds(49, 333, 117, 29);
		athleteBtn_2.setText(game.getTeam().get(2).getName());
		frame.getContentPane().add(athleteBtn_2);
		
		JButton athleteBtn_3 = new JButton("");
		athleteBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getTeam().get(3);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: " + currentAthlete.getPosition());
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_3.setBounds(178, 210, 117, 29);
		athleteBtn_3.setText(game.getTeam().get(3).getName());
		frame.getContentPane().add(athleteBtn_3);
		
		JButton athleteBtn_4 = new JButton("");
		athleteBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getTeam().get(4);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: " + currentAthlete.getPosition());
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_4.setBounds(49, 251, 117, 29);
		athleteBtn_4.setText(game.getTeam().get(4).getName());
		frame.getContentPane().add(athleteBtn_4);
		
		JButton athleteBtn_5 = new JButton("");
		athleteBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getTeam().get(5);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: " + currentAthlete.getPosition());
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_5.setBounds(178, 333, 117, 29);
		athleteBtn_5.setText(game.getTeam().get(5).getName());
		frame.getContentPane().add(athleteBtn_5);
		
		JButton athleteBtn_6 = new JButton("");
		athleteBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getTeam().get(6);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: " + currentAthlete.getPosition());
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_6.setBounds(49, 292, 117, 29);
		athleteBtn_6.setText(game.getTeam().get(6).getName());
		frame.getContentPane().add(athleteBtn_6);
		
		JButton athleteBtn_7 = new JButton("");
		athleteBtn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getReserves().get(0);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: Reserve");
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_7.setBounds(178, 251, 117, 29);
		athleteBtn_7.setText(game.getReserves().get(0).getName());
		frame.getContentPane().add(athleteBtn_7);
		
		JButton athleteBtn_8 = new JButton("");
		athleteBtn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getReserves().get(1);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: Reserve");
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_8.setBounds(49, 210, 117, 29);
		athleteBtn_8.setText(game.getReserves().get(1).getName());
		frame.getContentPane().add(athleteBtn_8);
		
		JButton athleteBtn_9 = new JButton("");
		athleteBtn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getReserves().get(2);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: Reserve");
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_9.setBounds(178, 292, 117, 29);
		athleteBtn_9.setText(game.getReserves().get(2).getName());
		frame.getContentPane().add(athleteBtn_9);
		
		JButton athleteBtn_10 = new JButton("");
		athleteBtn_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getReserves().get(3);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: Reserve");
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_10.setBounds(55, 374, 117, 29);
		athleteBtn_10.setText(game.getReserves().get(3).getName());
		frame.getContentPane().add(athleteBtn_10);
		
		JButton athleteBtn_11 = new JButton("");
		athleteBtn_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete currentAthlete = game.getReserves().get(4);
				athleteNameLbl.setText("Current Stamina: " + currentAthlete.getName());
				offenceLbl.setText("Offence Rating" + String.valueOf(currentAthlete.getOffence()));
				defenceLbl.setText("Defence Rating: " + String.valueOf(currentAthlete.getDefence()));
				positionLbl.setText("Position: Reserve");
				healthLbl.setText("Health Status: Healthy");
			}
		});
		athleteBtn_11.setBounds(178, 374, 117, 29);
		frame.getContentPane().add(athleteBtn_11);
		
		JLabel lblNewLabel = new JLabel("Click on an athlete to display their statistics");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(55, 140, 246, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton swapAthletesBtn = new JButton("Swap Athlete Positions");
		swapAthletesBtn.setBounds(518, 437, 176, 29);
		frame.getContentPane().add(swapAthletesBtn);
		
		
		
		
		
		
		
	}
}
