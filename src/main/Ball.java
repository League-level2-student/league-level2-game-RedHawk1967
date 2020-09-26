package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	
public int ball1speed = 3;
	
	public Ball(int xinfo, int yinfo, int widthinfo, int heightinfo, int speedinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, speedinfo);
		// TODO Auto-generated constructor stub
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(x, y, width, height);
	}
	
	public void right() {
		x+=ball1speed;
		}
		public void left() {
		x-=ball1speed;
		}
		public void down() {
		y+=ball1speed;
		}
		public void up() {
		y-=ball1speed;



}

public void ballspeedincrease() {
	
	ball1speed++;
	
}




}
