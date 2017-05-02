package gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class NFrame extends JFrame{
	static double version = 1.0;
	public NFrame(){
		setTitle("NickGen "+Double.toString(version));
		setSize(300,300);
		setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3, 10);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
