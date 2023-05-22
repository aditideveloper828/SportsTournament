package main;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultScreen {

	private JFrame frame;
	private ScreenManager manager;

	/**
	 * Create the application.
	 */
	public ResultScreen(ScreenManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	/*
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
		
		JLabel finalResultTitle = new JLabel(manager.getImplementation().getResultMessage());
		finalResultTitle.setBounds(22, 56, 634, 51);
		finalResultTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		finalResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(finalResultTitle);
		
		JLabel randomEventMessage = new JLabel(manager.getImplementation().getRandomEventMessage());
		randomEventMessage.setBounds(22, 151, 634, 51);
		randomEventMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		randomEventMessage.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(randomEventMessage);
		
		JButton playGameBtn = new JButton("NEXT");
		playGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		playGameBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		playGameBtn.setBounds(259, 418, 149, 35);
		frame.getContentPane().add(playGameBtn);
		
		JLabel currentPoints = new JLabel("Current Points: "+ manager.getImplementation().getGame().getPoints());
		currentPoints.setHorizontalAlignment(SwingConstants.CENTER);
		currentPoints.setFont(new Font("Dialog", Font.PLAIN, 10));
		currentPoints.setBounds(22, 233, 634, 51);
		frame.getContentPane().add(currentPoints);
		
		JLabel currentBalance = new JLabel("Current Balance: "+ manager.getImplementation().getGame().getBalance());
		currentBalance.setHorizontalAlignment(SwingConstants.CENTER);
		currentBalance.setFont(new Font("Dialog", Font.PLAIN, 10));
		currentBalance.setBounds(22, 294, 634, 51);
		frame.getContentPane().add(currentBalance);
		
		JLabel weeksRemaining = new JLabel("Weeks Remaining: "+ manager.getImplementation().remainingWeeks());
		weeksRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		weeksRemaining.setFont(new Font("Dialog", Font.PLAIN, 10));
		weeksRemaining.setBounds(22, 355, 634, 51);
		frame.getContentPane().add(weeksRemaining);
	}
	
	/*
	 * Method to initiate the disposal process of this screen and opening of the following screen.
	 */
	public void finishedWindow() {
		manager.closeResultScreen(this);
	}

}
