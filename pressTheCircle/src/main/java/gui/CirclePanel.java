package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import cirlceobjects.Kreis;
import game.Game;

public class CirclePanel extends JPanel {

	Kreis kreis = new Kreis();
	Game spiel = new Game(kreis);
	Random r = new Random();
	Timer timer = null;
	private int seconds = 0;
	private int deadline = 0;
	private boolean gameFinished = false;
	private boolean gameStart = false;
	private String level = "EASY";

	public CirclePanel() {
		setBackground(Color.white);

		// timer
		timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				seconds++;
				if ( seconds == deadline ) {
					seconds = 0;
					deadline = r.nextInt(1) + 1;
					spiel.gameOn();
					repaint();
				}
			}

		});

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if ( kreis.getCircleColor().equals(Color.WHITE) && gameStart ) {
					spiel.gameOn();
					repaint();
					deadline = r.nextInt(1) + 1;
					timer.start();
				}
				if ( kreis.getCircleColor().equals(Color.GREEN) ) {
					spiel.addPoint();
					repaint();
					if ( spiel.getPoints() == 100 ) {
						timer.stop();
						gameFinished = true;
						gameStart = false;
						spiel.setPoints(0);
					}

				}
				else if ( kreis.getCircleColor().equals(Color.RED) ) {
					spiel.losePoint();
					repaint();
					if ( spiel.getPoints() == 100 ) {
						timer.stop();
						gameFinished = true;
						gameStart = false;
						spiel.setPoints(0);
					}

				}

			}
		});
	}

	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Punkte : " + spiel.getPoints(), (this.getWidth() / 3) * 2, this.getHeight() / 9);
		g.drawString("Bei Rot : -1", 10, 60);
		g.drawString("Bei Grün : +1", 10, 75);
		g.drawString("Schwierigkeit : " + this.level, 10, 40);
		g.drawString("Erreiche 100 Punkte", 10, 90);
		if ( gameFinished ) {
			kreis.setCircleColor(Color.white);
			g.drawString("GEWONNEN", 10, 20);
			gameFinished = false;
		}
		else {
			kreis.setCircleWidth(this.getWidth() / 3);
			kreis.setCirlceHeight(this.getHeight() / 3);
			kreis.setPosX(this.getWidth() / 3);
			kreis.setPosY(this.getHeight() / 3);
			kreis.paintComponent(g);
		}

	}

	// game Configurations
	public void startNewGame() {
		this.gameStart = true;
		this.timer.stop();
		this.seconds = 0;
		this.deadline = 0;
		spiel.setPoints(0);
		this.gameFinished = false;
		kreis.setCircleColor(Color.white);
		repaint();
	}

	public void setLevelToEasy() {
		this.timer.setDelay(1000);
		this.startNewGame();
		this.level = "EASY";
	}

	public void setLevelToMedium() {
		this.timer.setDelay(500);
		this.startNewGame();
		this.level = "Not yet hard :D";
	}

	public void setLevelToHard() {
		this.timer.setDelay(250);
		this.startNewGame();
		this.level = "Not baaad!";
	}

	public void setLevelToUNHUMAN() {
		this.timer.setDelay(100);
		this.startNewGame();
		this.level = "OMG! WHAT A MONSTER!";
	}
}
