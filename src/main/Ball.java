package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	GamePanel gpanel;

	public int ball1speed = 3;

	public Ball(int xinfo, int yinfo, int widthinfo, int heightinfo, int speedinfo, GamePanel gpanel) {
		super(xinfo, yinfo, widthinfo, heightinfo, speedinfo);
		// TODO Auto-generated constructor stub
		this.gpanel = gpanel;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(x, y, width, height);
	}

	public void right() {
		for (int i = 0; i < ball1speed; i++) {

			x += 1;
			update();
			gpanel.checkCollison();
			
		}
	}

	public void left() {
		for (int i = 0; i < ball1speed; i++) {

			x -= 1;
			update();
			gpanel.checkCollison();
		}
	}

	public void down() {

		for (int i = 0; i < ball1speed; i++) {

			y += 1;
			update();
			gpanel.checkCollison();
		}
	}

	public void up() {
		for (int i = 0; i < ball1speed; i++) {

			y -= 1;
			update();
			gpanel.checkCollison();
		}

	}

	public void ballspeedincrease() {

		ball1speed++;

	}

}
