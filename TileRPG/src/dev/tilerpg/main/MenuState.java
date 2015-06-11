package dev.tilerpg.main;

import java.awt.Color;
import java.awt.Graphics;

import dev.tilerpg.state.State;

public class MenuState extends State {

	@Override
	public void update() {
	}

	@Override
	public void display(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Main Menu", Game.WIDTH / 2 - (g.getFontMetrics().stringWidth("Main Menu") /2 ), Game.HEIGHT / 3);
	}
	
	class Menu {
		MenuItem[] items;
		
		public Menu(int size) {
			items = new MenuItem[size];
		}
		
		public void render(Graphics g) {
			
		}
	}
	
	class MenuItem {
		
//		interface Function {
//			public void do();
//		}
	}
}
