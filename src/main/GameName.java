package main;

import javax.swing.JFrame;

public class GameName {
	
	GamePanel gpanel;
	
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	public static void main(String[] args) {
		GameName gname = new GameName();
		gname.setup();
		
	}


	JFrame gframe;
	

	public GameName() {
		 gpanel = new GamePanel();
gframe = new JFrame();
	}

	
	

	


public void setup() {
	//gframe.add(gpanel);
	
	gframe.setSize(WIDTH,HEIGHT);
	gframe.addKeyListener(gpanel);
	gframe.setVisible(true);
	gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
