package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen {

	private JFrame frame;
	private ScreenManager manager;

	/**
	 * Create the application.
	 */
	public WelcomeScreen(ScreenManager incomingManager) {
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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeMsg = new JLabel("Welcome to the Quadball Tournament!");
		welcomeMsg.setBounds(34, 55, 624, 29);
		welcomeMsg.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		frame.getContentPane().add(welcomeMsg);
		
		JLabel sponsorMsg = new JLabel("Proudly sponsored by Aditi + Immy");
		sponsorMsg.setBounds(211, 96, 273, 16);
		sponsorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		sponsorMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		frame.getContentPane().add(sponsorMsg);
		
		JButton startSsnBtn = new JButton("START NEW SEASON");
		startSsnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		startSsnBtn.setBounds(215, 295, 269, 41);
		startSsnBtn.setBackground(new Color(62, 160, 255));
		startSsnBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(startSsnBtn);
	}
	
	public void finishedWindow() {
		manager.closeWelcomeScreen(this);
	}
}
