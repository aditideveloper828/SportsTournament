package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen {

	private JFrame frame;
	private static ScreenManager manager;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainScreen window = new MainScreen();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainScreen(ScreenManager incomingManager) {
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
		
		JButton goToClubBtn = new JButton("Go To Club");
		goToClubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchClubScreen();
			}
		});
		goToClubBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		goToClubBtn.setBounds(237, 148, 206, 42);
		frame.getContentPane().add(goToClubBtn);
		
		JButton goToMarketBtn = new JButton("Go To Market");
		goToMarketBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchPurchaseScreen();
			}
		});
		goToMarketBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		goToMarketBtn.setBounds(237, 223, 206, 42);
		frame.getContentPane().add(goToMarketBtn);
		
		JButton playNxtMatchBtn = new JButton("Play Next Match");
		playNxtMatchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInitiateMatchScreen();
			}
		});
		playNxtMatchBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		playNxtMatchBtn.setBounds(123, 302, 206, 42);
		frame.getContentPane().add(playNxtMatchBtn);
		
		JLabel homeScreenTitle = new JLabel("Home");
		homeScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		homeScreenTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		homeScreenTitle.setBounds(269, 48, 145, 47);
		frame.getContentPane().add(homeScreenTitle);
		
		JButton takeAByeBtn = new JButton("Take A Bye");
		takeAByeBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		takeAByeBtn.setBounds(351, 302, 206, 42);
		frame.getContentPane().add(takeAByeBtn);
	}
	
	
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}
	

}
