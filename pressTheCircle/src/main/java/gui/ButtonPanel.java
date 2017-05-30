package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	JButton start = new JButton("Start"), easy = new JButton("Easy"), medium = new JButton("Medium"),
			hard = new JButton("Hard"), unhuman = new JButton("UNHUMAN");
	CirclePanel config = null;

	public ButtonPanel(CirclePanel panel) {
		setLayout(new GridLayout(5, 1));
		ActionListener aktion = new Aktion();
		this.config = panel;

		add(start);
		start.addActionListener(aktion);
		add(easy);
		easy.addActionListener(aktion);
		add(medium);
		medium.addActionListener(aktion);
		add(hard);
		hard.addActionListener(aktion);
		add(unhuman);
		unhuman.addActionListener(aktion);
	}

	private class Aktion implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(start) ) {
				config.startNewGame();
			}
			if ( e.getSource().equals(easy) ) {
				config.setLevelToEasy();
			}
			if ( e.getSource().equals(medium) ) {
				config.setLevelToMedium();
			}
			if ( e.getSource().equals(hard) ) {
				config.setLevelToHard();
			}
			if ( e.getSource().equals(unhuman) ) {
				config.setLevelToUNHUMAN();
			}
		}

	}

}
