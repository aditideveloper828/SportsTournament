package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel finalResultTitle = new JLabel("CONGRATS! YOU WON YOUR GAME");
		finalResultTitle.setBounds(33, 37, 634, 51);
		finalResultTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		finalResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(finalResultTitle);
	}

}
