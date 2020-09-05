package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener  {
	public int paddleSpawnx0 = 595;
	public int paddleSpawny0 = 179;
	public int paddleSpawnx1 = 20;
	public int paddleSpawny1 = 179;
	public int ballSpawnx = 318;
	public int ballSpawny = 179;
	Timer frameDraw;
	Font MenuFont;
	Font SmallFont;
	Paddle paddle0 = new Paddle(paddleSpawnx0,paddleSpawny0,10,50,10);
	Paddle paddle1 = new Paddle(paddleSpawnx1,paddleSpawny1,10,50,10);
	Ball ball1 = new Ball(ballSpawnx, ballSpawny, 5, 5, 75);
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
	
	
	void startGame( ) {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
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
		paddle0.draw(g);
		paddle1.draw(g);
		ball1.draw(g);
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
			
			if (currentState > 2) {
				currentState = 0;
			}
		startGame();
		}
		
		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_UP && paddle0.y > 0){
				
				paddle0.up();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && paddle0.y < 265) {
				paddle0.down();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle0.x > 328) {
				paddle0.left();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle0.x < 605) {
				paddle0.right(); System.out.println(paddle0.x);	
			}
		
			if (e.getKeyCode() == KeyEvent.VK_W && paddle1.y > 0){
				
				paddle1.up();
			}
			if (e.getKeyCode() == KeyEvent.VK_S && paddle1.y < 265) {
				paddle1.down();
			}
			if (e.getKeyCode() == KeyEvent.VK_A && paddle1.x > 0) {
				paddle1.left();
			}
			if (e.getKeyCode() == KeyEvent.VK_D && paddle1.x < 308) {
				paddle1.right();	
			}

		
		}
		
		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		
			repaint();
		
		}
	
	
}
