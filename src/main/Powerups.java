package main;

import java.awt.Color;
import java.awt.Graphics;

public class Powerups extends GameObject{

	public Powerups(int xinfo, int yinfo, int widthinfo, int heightinfo, int speedinfo ) {
		super(xinfo, yinfo, widthinfo, heightinfo, speedinfo);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		//powerup1
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}

	public void close() {
		// TODO Auto-generated method stub
//closes powerups when they are used
	
	
	}


}
