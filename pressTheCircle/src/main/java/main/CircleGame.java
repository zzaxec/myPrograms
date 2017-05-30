package main;

import java.awt.EventQueue;

import gui.CircleFrame;

public class CircleGame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CircleFrame f = new CircleFrame();
			}

		});
	}

}
