package cirlceobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class Kreis implements Observer {
	private int posX;
	private int posY;
	private int circleWidth = 250;
	private int cirlceHeight = 250;
	private Color circleColor = Color.WHITE;

	public Kreis() {
		this.posX = 0;
		this.posY = 0;
	}

	public void paintComponent(Graphics g) {
		g.setColor(this.circleColor);
		g.fillOval(this.posX, this.posY, this.circleWidth, this.cirlceHeight);
		g.drawOval(this.posX, this.posY, this.circleWidth, this.cirlceHeight);
	}

	// Getter and Setter

	public Color getCircleColor() {
		return circleColor;
	}

	public void setCircleColor(Color circleColor) {
		this.circleColor = circleColor;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getCircleWidth() {
		return circleWidth;
	}

	public void setCircleWidth(int circleWidth) {
		this.circleWidth = circleWidth;
	}

	public int getCirlceHeight() {
		return cirlceHeight;
	}

	public void setCirlceHeight(int cirlceHeight) {
		this.cirlceHeight = cirlceHeight;
	}

	// Oberserver methods
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
