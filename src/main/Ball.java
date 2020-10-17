package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	GamePanel gpanel;
	int xvelocity = 3;
	int yvelocity = 0;
			
	public int speed = 3;

	public Ball(int xinfo, int yinfo, int widthinfo, int heightinfo, int speedinfo, GamePanel gpanel) {
		super(xinfo, yinfo, widthinfo, heightinfo, speedinfo);
		// TODO Auto-generated constructor stub
		this.gpanel = gpanel;
	}
	
	@Override
	public void update() {
		super.update();
		if (xvelocity >= 0) {
		right();
		}else {
			left();
		}
		
		if (yvelocity >= 0) {
			down();
			}else {
				up();
			}

	}
	 
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(x, y, width, height);
	}

	public void right() {
		for (int i = 0; i < xvelocity; i++) {

			x += 1;
			super.update();
			gpanel.checkCollison();
			
		}
	}

	public void left() {
		for (int i = xvelocity; i < 0; i++) {

			x -= 1;
			super.update();
			gpanel.checkCollison();
		}
	}

	public void down() {

		for (int i = 0; i < yvelocity; i++) {

			y += 1;
			super.update();
			gpanel.checkCollison();
		}
	}

	public void up() {
		for (int i = yvelocity; i < 0; i++) {

			y -= 1;
			super.update();
			gpanel.checkCollison();
		}

	}

	

}
