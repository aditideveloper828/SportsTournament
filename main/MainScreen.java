package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI implementation for the home screen. Allows a user to choose what to do next
 */
public class MainScreen {

	private JFrame frame;
	private ScreenManager manager;


	/**
	 * Create the application.
	 * 
	 * @param incomingManager calling the screenManager class
	 */
	public MainScreen(ScreenManager incomingManager) {
		manager = incomingManager;
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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton goToClubBtn = new JButton("Go To Club");
		goToClubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchClubScreen();
				finishedWindow();
			}
		});
		goToClubBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		goToClubBtn.setBounds(237, 148, 206, 42);
		frame.getContentPane().add(goToClubBtn);
		
		JButton goToMarketBtn = new JButton("Go To Market");
		goToMarketBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchPurchaseScreen();
				finishedWindow();
			}
		});
		goToMarketBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		goToMarketBtn.setBounds(237, 223, 206, 42);
		frame.getContentPane().add(goToMarketBtn);
		
		JButton playNxtMatchBtn = new JButton("Play Next Match");
		playNxtMatchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
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
		takeAByeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchByeWeekScreen();
				finishedWindow();
			}
		});
		takeAByeBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		takeAByeBtn.setBounds(351, 302, 206, 42);
		frame.getContentPane().add(takeAByeBtn);
	}
	
	/**
	 * Method to initiate the disposal process of this screen and opening of the following screen.
	 */
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}
	

}
