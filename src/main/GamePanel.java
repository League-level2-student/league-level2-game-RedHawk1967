package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GamePanel implements KeyListener {

	Font MenuFont;
	Font SmallFont;
	
	private BufferedImage background;
	public GamePanel() {
		MenuFont = new Font("Arial", Font.PLAIN, 48);
		SmallFont = new Font("Arial", Font.PLAIN, 25);
	
	}
	final int END = 2;
	final int MENU = 0;
	final int GAME = 1;
	int currentState = MENU;
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}
		void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameName.WIDTH, GameName.HEIGHT);
		g.setFont(MenuFont);
		g.setColor(Color.WHITE);
		g.drawString("GAMENAME", 50, 100);
		g.setFont(SmallFont);
		g.drawString("Press Enter To Start", 100, 400);
		 
	}
		void drawGameState(Graphics g) {
			try {
				background =ImageIO.read(getClass().getResourceAsStream("download.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}	
			g.drawImage(background,0,0,null);
		}

		
		
		void drawEndState(Graphics g) {
		
		
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			// left rect up w down s
			//right rect up up arrow down down arrow
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
}
