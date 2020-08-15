package main;

import javax.swing.JFrame;

public class PONG {
	
	GamePanel gpanel;
	
	
	public static final int WIDTH = 637;
	public static final int HEIGHT = 358;
	
	public static void main(String[] args) {
		PONG gname = new PONG();
		gname.setup();
		
	}


	JFrame gframe;
	

	public PONG() {
		 gpanel = new GamePanel();
gframe = new JFrame();
	}

	
	//circle pong idea
	//powerups ex if ball hits speed the ball goes faster or slow mo power

	


public void setup() {
	gframe.add(gpanel);
	
	gframe.setSize(WIDTH,HEIGHT);
	gframe.addKeyListener(gpanel);
	gframe.setVisible(true);
	gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
