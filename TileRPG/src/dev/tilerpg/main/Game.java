package dev.tilerpg.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import dev.tilerpg.state.MenuState;
import dev.tilerpg.state.State;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 320,
			HEIGHT = (WIDTH * 9) / 12;
	
	private static JFrame frame;
	private BufferStrategy buffer;
	private Graphics g;

	private static State currentState;
	
	private Thread thread;
	private static KeyboardInput keyIn;
	
	public Game() {
		
		keyIn = new KeyboardInput();
		
		addKeyListener(keyIn);
		
		currentState = new MenuState("Main Menu");
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double ns = 1000000000 / 60;
		double delta = 0;
		long now;
		long timer = System.currentTimeMillis();
		int updates = 0, fps = 0;
		
		while(true) {
			now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				delta--;
				updates++;
			}
			
			display();
			fps++;
			
			if(System.currentTimeMillis() - timer >= 1000) {
				timer = System.currentTimeMillis();
				System.out.println("Updates: "+updates+" Frames: "+fps);
				updates = 0;
				fps = 0;
			}
		}
	}
	
	public void update() {
		currentState.update();
	}
	
	public void display() {
		buffer = this.getBufferStrategy();
		
		if(buffer == null)  {
			createBufferStrategy(3);
			return;
		}
		
		g = buffer.getDrawGraphics();
		
		//-
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		currentState.display(g);
		//-
		
		g.dispose();
		buffer.show();
	}
	
	public static void main(String[] args) {
		frame = new JFrame("TileRPG");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game game = new Game();
		
		frame.add(game);
		frame.setResizable(false);
		frame.setVisible(true);
		
		game.start();
	}
	
	public static void setState(State st) {
		currentState = st;
	}
	
	public static KeyboardInput getKeyInput() {
		return keyIn;
	}
}
