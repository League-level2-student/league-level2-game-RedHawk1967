package main;

import java.awt.Rectangle;

public class GameObject {

	Paddle paddle0;
	Paddle paddle1;
	Ball ball1;

	Rectangle collisionBox;

	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	  boolean isActive = true;

	 public GameObject(int xinfo,int yinfo, int widthinfo, int heightinfo, int speedinfo) {

	collisionBox = new Rectangle(xinfo,yinfo,widthinfo,heightinfo);
	 x = xinfo;
	  y = yinfo;
	  width = widthinfo;
	   height = heightinfo;
	   speed = speedinfo;
	 
	 
	 }







	public void update() { 
		collisionBox.setBounds(x, y, width, height);
		
	}


	private void checkCollison() {
		
		
		if (paddle0.collisionBox.intersects(ball1.collisionBox)) {
			ball1.left(); System.out.println("hit paddle0");
		
		}
		if (paddle1.collisionBox.intersects(ball1.collisionBox)) {
			ball1.right(); System.out.println("hit paddle1");
		}
		
		
	}






}

