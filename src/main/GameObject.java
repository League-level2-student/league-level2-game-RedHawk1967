package main;

import java.awt.Rectangle;

public class GameObject {




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


}

