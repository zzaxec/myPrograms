package gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CircleFrame extends JFrame {

	public CircleFrame() {
		setTitle("Circle");
		setLayout(new BorderLayout());
		setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3,
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4);
		setResizable(false);
		CirclePanel circlepanel = new CirclePanel();
		add(circlepanel, BorderLayout.NORTH);
		add(new ButtonPanel(circlepanel), BorderLayout.SOUTH);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
