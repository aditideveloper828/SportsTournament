package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * GUI implementation of the final results at completion of the game. 
 * Displays the points gained, money gained, and the season duration
 */
public class FinishScreen {

	private JFrame frame;
	private ScreenManager manager;

	/**
	 * Create the application.
	 * 
	 * @param incomingManager calling the screenManager class
	 */
	public FinishScreen(ScreenManager incomingManager) {
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
		frame.setBounds(100, 100, 739, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel finalResultTitle = new JLabel("Your Final Status!");
		finalResultTitle.setBounds(33, 37, 634, 51);
		finalResultTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		finalResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(finalResultTitle);
		
		JLabel teamName = new JLabel("Team Name: " + manager.getImplementation().getGame().getTeamName());
		teamName.setHorizontalAlignment(SwingConstants.CENTER);
		teamName.setFont(new Font("Dialog", Font.PLAIN, 14));
		teamName.setBounds(33, 107, 634, 51);
		frame.getContentPane().add(teamName);
		
		JLabel finalPoints = new JLabel("Final Points: "+manager.getImplementation().getGame().getPoints());
		finalPoints.setHorizontalAlignment(SwingConstants.CENTER);
		finalPoints.setFont(new Font("Dialog", Font.PLAIN, 14));
		finalPoints.setBounds(33, 168, 634, 51);
		frame.getContentPane().add(finalPoints);
		
		JLabel finalBalance = new JLabel("Final Balance: "+manager.getImplementation().getGame().getBalance());
		finalBalance.setHorizontalAlignment(SwingConstants.CENTER);
		finalBalance.setFont(new Font("Dialog", Font.PLAIN, 14));
		finalBalance.setBounds(33, 225, 634, 51);
		frame.getContentPane().add(finalBalance);
		
		JLabel seasonDuration = new JLabel("Season Duration: "+manager.getImplementation().getSeasonDuration());
		seasonDuration.setHorizontalAlignment(SwingConstants.CENTER);
		seasonDuration.setFont(new Font("Dialog", Font.PLAIN, 14));
		seasonDuration.setBounds(33, 286, 634, 51);
		frame.getContentPane().add(seasonDuration);
		
		JButton endBtn = new JButton("Quit");
		endBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		endBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		endBtn.setBounds(275, 347, 149, 35);
		frame.getContentPane().add(endBtn);
	}
	
	/**
	 * Method to initiate the disposal process of this screen and opening of the following screen.
	 */
	public void finishedWindow() {
		manager.closeFinishScreen(this);
	}

}
