package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	Random randgen = new Random();

	ArrayList<Powerups> poweruparray = new ArrayList<Powerups>();

	int framecount = 0;
	public int paddleSpawnx0 = 595;
	public int paddleSpawny0 = 179;
	public int paddleSpawnx1 = 20;
	public int paddleSpawny1 = 179;
	public int ballSpawnx = 318;
	public int ballSpawny = 179;

	Timer Poweruptime;
	Timer frameDraw;
	Font MenuFont;
	Font SmallFont;

	Paddle paddle0 = new Paddle(paddleSpawnx0, paddleSpawny0, 10, 50, 20);
	Paddle paddle1 = new Paddle(paddleSpawnx1, paddleSpawny1, 10, 50, 20);
	Ball ball1 = new Ball(ballSpawnx, ballSpawny, 5, 5, 25, this);
	private BufferedImage background;

	public GamePanel() {
		MenuFont = new Font("Arial", Font.PLAIN, 48);
		SmallFont = new Font("Arial", Font.PLAIN, 25);
		Powerups powerup0 = new Powerups(randgen.nextInt(560), randgen.nextInt(290), 30, 30, 0);
		Powerups powerup1 = new Powerups(randgen.nextInt(560), randgen.nextInt(290), 30, 30, 0);
		Powerups powerup2 = new Powerups(randgen.nextInt(560), randgen.nextInt(290), 30, 30, 0);
		poweruparray.add(powerup0);
		poweruparray.add(powerup1);
		poweruparray.add(powerup2);

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

	void startGame() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		Poweruptime = new Timer(1000 / 60, this);

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

	public void updateGameState() {
		paddle0.update();
		paddle1.update();
		ball1.update();

		for (int i = 0; i < poweruparray.size(); i++) {
			poweruparray.get(i).update();

		}
		checkCollison();
	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PONG.WIDTH, PONG.HEIGHT);

		paddle0.draw(g);
		System.err.println(ball1.speed);
		paddle1.draw(g);
		ball1.draw(g);
		for (int i = 0; i < poweruparray.size(); i++) {
			poweruparray.get(i).draw(g);

		}

		// ballspeed++;
		framecount++;
		;

		if (framecount % 100 == 0) {
			ball1.speed++;
		}
		if (ball1.x > 638 || ball1.x < 1) {
			currentState = END;
		}

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PONG.WIDTH, PONG.HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(MenuFont);
		g.drawString("well you lost", 100, 100);

	}

	public void checkCollison() {
		for (int i = poweruparray.size() - 1; i >= 0; i--) {

			if (ball1.x > poweruparray.get(i).x - 30 && ball1.x < poweruparray.get(i).x + 30
					&& ball1.y > poweruparray.get(i).y - 30 && ball1.y < poweruparray.get(i).y + 30) {

				if (i == 0) {
					ball1.x = randgen.nextInt(600);
					ball1.y = randgen.nextInt(320);
					ball1.speed = 1;
					
				} else if (i == 1) {
					
					ball1.xvelocity = -ball1.xvelocity;

				} else if (i == 2) {
					
					ball1.yvelocity = -ball1.yvelocity;
				}
				poweruparray.remove(i);
			}
		}
		if (paddle0.collisionBox.intersects(ball1.collisionBox)) {
			ball1.xvelocity = -ball1.speed;
			int ydiff = ball1.y - paddle0.y;
			if (ydiff <= 20) {
				ball1.yvelocity = -3;
			} else if (ydiff < 1) {
				ball1.yvelocity = 0;
			} else {
				ball1.yvelocity = 3;
			}

		}
		if (paddle1.collisionBox.intersects(ball1.collisionBox)) {
			ball1.xvelocity = ball1.speed;
		}

		if (ball1.y < 5) {
			ball1.yvelocity = 3;
		}

		if (ball1.y > 320) {
			ball1.yvelocity = -3;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// left rect up w down s
		// right rect up up arrow down down arrow
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			System.out.println("keypressed worked");
			
			currentState++;
			ball1 = new Ball(ballSpawnx, ballSpawny, 5, 5, 25, this);
			if (frameDraw !=null) {
				frameDraw.stop();
			}
			
			ball1.yvelocity = 0;
			ball1.xvelocity = 3;
			ball1.speed = 3;
			framecount = 0;
			ball1.xvelocity = 3;
			ball1.yvelocity = 0;
			ball1.speed = 3;
			paddle1.x = paddleSpawnx1;
			paddle1.y = paddleSpawny1;
			paddle0.x = paddleSpawnx0;
			paddle0.y = paddleSpawny0;
			if (currentState > 2) {
				currentState = 0;
			}
			startGame();
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN && paddle0.y < 265) {
			paddle0.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle0.x > 328) {
			paddle0.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle0.x < 605) {
			paddle0.right();
		}

		if (e.getKeyCode() == KeyEvent.VK_W && paddle1.y > 0) {

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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		updateGameState();
		repaint();

	}

}
