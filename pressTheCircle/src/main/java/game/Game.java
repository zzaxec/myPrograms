package game;

import java.awt.Color;
import java.util.Random;

import cirlceobjects.Kreis;

public class Game {
	private int points;
	Kreis kreis;

	public Game(Kreis kr) {
		this.kreis = kr;
		this.points = 0;
	}

	public void gameOn() {
		Random r = new Random();
		if ( r.nextBoolean() ) {
			kreis.setCircleColor(Color.GREEN);
		}
		else
			kreis.setCircleColor(Color.RED);
	}

	// getter and setter

	public void addPoint() {
		this.points++;
	}

	public void losePoint() {
		this.points--;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
