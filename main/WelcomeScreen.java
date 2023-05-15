package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class WelcomeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
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
	public WelcomeScreen() {
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
		
		JLabel welcomeMsg = new JLabel("Welcome to the Quadball Tournament!");
		welcomeMsg.setBounds(35, 54, 378, 29);
		welcomeMsg.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(welcomeMsg);
		
		JLabel sponsorMsg = new JLabel("Proudly sponsored by Aditi + Immy");
		sponsorMsg.setBounds(122, 83, 168, 16);
		sponsorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		sponsorMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		frame.getContentPane().add(sponsorMsg);
		
		JButton startSsnBtn = new JButton("START NEW SEASON");
		startSsnBtn.setBackground(new Color(62, 160, 255));
		startSsnBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		startSsnBtn.setBounds(82, 142, 256, 41);
		frame.getContentPane().add(startSsnBtn);
	}
}
