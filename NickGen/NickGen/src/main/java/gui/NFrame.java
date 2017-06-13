package gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class NFrame extends JFrame {
	static double version = 2.1;

	public NFrame() {
		setTitle("NickGen " + Double.toString(version));
		setSize(420, 400);
		setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3, 10);

		NPanel npanel = new NPanel();
		add(npanel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
