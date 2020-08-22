package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener  {
	public int paddleSpawnx0 = 620;
	public int paddleSpawny0 = 179;
	public int paddleSpawnx1 = 20;
	public int paddleSpawny1 = 179;
	public int ballSpawnx = 318;
	public int ballSpawny = 179;
	Font MenuFont;
	Font SmallFont;
	Paddle paddle0 = new Paddle(paddleSpawnx0,paddleSpawnx0,10,50,10);
	Paddle paddle1 = new Paddle(paddleSpawnx1,paddleSpawny1,10,50,10);
	Ball ball = new Ball(ballSpawnx, ballSpawny, 5, 5, 75);
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
		g.fillRect(0, 0, PONG.WIDTH, PONG.HEIGHT);
		g.setFont(MenuFont);
		g.setColor(Color.WHITE);
		g.drawString("PONG", 50, 100);
		g.setFont(SmallFont);
		g.drawString("Press Enter To Start", 100, 300);
		g.drawString("By Jack", 200, 100);
	
		 
	}
		void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PONG.WIDTH, PONG.HEIGHT);
		
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
		}
		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
}
