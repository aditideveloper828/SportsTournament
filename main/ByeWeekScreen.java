package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ByeWeekScreen {

	private JFrame frame;
	private ScreenManager manager;

	/**
	 * Create the application.
	 */
	public ByeWeekScreen(ScreenManager incomingManager) {
		manager = incomingManager;
		initialize();
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
		
		JLabel byeTitle = new JLabel("You took a Bye!");
		byeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		byeTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		byeTitle.setBounds(260, 59, 155, 30);
		frame.getContentPane().add(byeTitle);
		
		JButton btnNewButton = new JButton("Return To Club");
		btnNewButton.setBounds(260, 397, 155, 29);
		frame.getContentPane().add(btnNewButton);
	}

}
