package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import methods.Methods;
import nicknamegenerator.Generator;

public class NPanel extends JPanel {
	// Components
	JPanel defaultPanel = new JPanel(), randomPanel = new JPanel(), savePanel = new JPanel();
	JButton consonant = new JButton("K"), vocal = new JButton("V"),
			clear = new JButton("Clear Structure"), start = new JButton("Generate"),
			randomStart = new JButton("Generate Random"), save = new JButton("Save"),
			clearNicks = new JButton("Delete Nicknames");
	JTextPane nicknameField = new JTextPane();
	JComboBox<Integer> comboBox = new JComboBox<Integer>();
	private String structure = "";
	Generator g = new Generator();
	private String tempNickname = "";

	public NPanel() {
		setLayout(new GridLayout(4, 1));
		// ActionListener
		ActionListener alistener = new AListener();
		ActionListener randomListener = new RandomListener();
		ActionListener saveListener = new SaveListener();

		// combobox initialized with the numbers 1 to 10
		for ( int i = 1; i < 11; i++ ) {
			comboBox.addItem(i);
		}

		// configurations of buttons
		consonant.addActionListener(alistener);
		vocal.addActionListener(alistener);
		clear.addActionListener(alistener);
		start.addActionListener(alistener);
		randomStart.addActionListener(randomListener);
		save.addActionListener(saveListener);
		clearNicks.addActionListener(saveListener);

		// configurations for default Panel
		defaultPanel.setLayout(new GridLayout(1, 3));
		defaultPanel.add(consonant);
		defaultPanel.add(vocal);
		defaultPanel.add(clear);
		defaultPanel.add(start);

		// configurations for random panel
		randomPanel.setLayout(new GridLayout(1, 2));
		randomPanel.add(comboBox);
		randomPanel.add(randomStart);

		// configuration for saving panel
		savePanel.setLayout(new GridLayout(1, 2));
		savePanel.add(save);
		savePanel.add(clearNicks);

		// nicknamefield specified
		nicknameField.setText("Create your own Nickname" + "\n" + "Structure :");
		nicknameField.setEnabled(false);
		nicknameField.setEditable(false);

		// nicknamefield style
		StyledDocument doc = nicknameField.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		add(nicknameField);

		add(defaultPanel);
		add(randomPanel);
		add(savePanel);

	}

	private class AListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(consonant) ) {
				structure += "k";
				nicknameField.setText("Create your own Nickname" + "\n" + "Structure :" + structure);
			}
			if ( e.getSource().equals(vocal) ) {
				structure += "v";
				nicknameField.setText("Create your own Nickname" + "\n" + "Structure :" + structure);
			}
			if ( e.getSource().equals(clear) ) {
				structure = "";
				nicknameField
						.setText("Eingaben sind gelöscht." + "\n" + "Sie können nun von vorne beginnen");
			}
			if ( e.getSource().equals(start) ) {
				tempNickname = g.RandomNick(structure);
				nicknameField.setText("Your new Nickname is :" + "\n" + tempNickname);
			}
		}

	}

	private class RandomListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(randomStart) ) {
				tempNickname = g.nextRandomNick(comboBox.getItemAt(comboBox.getSelectedIndex()));
				nicknameField.setText("Your random Nickname is :" + "\n" + tempNickname);
			}
		}

	}

	private class SaveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(save) ) {
				Methods.writeNickName(tempNickname);
			}
			if ( e.getSource().equals(clearNicks) ) {
				Methods.deletNicknameFile();
			}
		}

	}
}
