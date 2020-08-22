package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	public Ball(int xinfo, int yinfo, int widthinfo, int heightinfo, int speedinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, speedinfo);
		// TODO Auto-generated constructor stub
	}

	
	private void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(x, y, width, height);
	}
	
}
