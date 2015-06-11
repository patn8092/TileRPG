package dev.tilerpg.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private static int WIDTH = 320,
			HEIGHT = (WIDTH * 9) / 12;
	
	private static JFrame frame;
	private BufferStrategy buffer;
	private Graphics g;
	
	private Thread thread;
	
	public Game() {
		
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
		
		while(true) {
			now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1){
				update();
				//System.out.println("Tick");
				delta--;
			}
			
			display();
		}
	}
	
	public void update() {
		
	}
	
	public void display() {
		buffer = this.getBufferStrategy();
		
		if(buffer == null)  {
			createBufferStrategy(3);
			return;
		}
		
		g = buffer.getDrawGraphics();
		
		//-
		g.fillRect(0, 0, WIDTH, HEIGHT);
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
}
