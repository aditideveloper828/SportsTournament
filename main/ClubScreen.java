package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClubScreen {

	private static JFrame frame;
	private static PurchasableManager data;
	private static ScreenManager manager;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClubScreen window = new ClubScreen();
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
	public ClubScreen(PurchasableManager incomingData, ScreenManager incomingManager) {
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
		
	}
}
