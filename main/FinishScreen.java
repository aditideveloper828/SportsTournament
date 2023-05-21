package main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FinishScreen {

	private JFrame frame;
	private ScreenManager manager;

	/**
	 * Create the application.
	 */
	public FinishScreen(ScreenManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel finalResultTitle = new JLabel("CONGRATS! YOU WON YOUR GAME");
		finalResultTitle.setBounds(33, 37, 634, 51);
		finalResultTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		finalResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(finalResultTitle);
	}

}
