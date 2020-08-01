package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel implements KeyListener {

	Font MenuFont;
	Font SmallFont;
	
	
	public GamePanel() {
		MenuFont = new Font("Arial", Font.PLAIN, 48);
		SmallFont = new Font("Arial", Font.PLAIN, 25);
	
	}
		
	final int MENU = 0;
	final int GAME = 1;
	
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
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
			

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
}
