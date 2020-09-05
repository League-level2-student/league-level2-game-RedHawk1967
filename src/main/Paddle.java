package main;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject {

	public Paddle(int xinfo, int yinfo, int widthinfo, int heightinfo, int speedinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, speedinfo);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
	}



	public void right() {
		x+=speed;
		}
		public void left() {
		x-=speed;
		}
		public void down() {
		y+=speed;
		}
		public void up() {
		y-=speed;



}
}