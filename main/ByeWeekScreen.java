package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ByeWeekScreen {

	private JFrame frame;
	private ScreenManager manager;

	/**
	 * Create the application.
	 */
	public ByeWeekScreen(ScreenManager incomingManager) {
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
		ArrayList<Athlete> options = manager.getImplementation().getFullTeam();
		Athlete[] values = new Athlete[options.size()];
		for (int i = 0; i < options.size(); i++) {
			values[i] = options.get(i);
		}
		
		
		JLabel byeTitle = new JLabel("You took a Bye!");
		byeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		byeTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		byeTitle.setBounds(260, 59, 155, 30);
		frame.getContentPane().add(byeTitle);
		
		JComboBox<Athlete> specialTraining = new JComboBox<Athlete>();
		specialTraining.setModel(new DefaultComboBoxModel<Athlete>(values));
		specialTraining.setMaximumRowCount(20);
		specialTraining.setFont(new Font("Dialog", Font.PLAIN, 13));
		specialTraining.setBounds(116, 157, 496, 27);
		frame.getContentPane().add(specialTraining);
		
		JButton btnNewButton = new JButton("Return To Club");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chosen = specialTraining.getSelectedIndex();
				String position = options.get(chosen).getPosition();
				if (position == "RESERVE") {
					chosen -= manager.getImplementation().getGame().getTeamSize();
				}
				manager.getImplementation().specialTraining(chosen, position);
				finishedWindow();
			}
		});
		btnNewButton.setBounds(289, 397, 155, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("You can select one of your athletes to go through special training!");
		lblNewLabel.setBounds(189, 115, 464, 13);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void finishedWindow() {
		manager.closeByeWeekScreen(this);
	}

}
