package dev.tilerpg.state;

import java.awt.Color;
import java.awt.Graphics;

import com.sun.glass.events.KeyEvent;

import dev.tilerpg.main.Game;

public class MenuState extends State {
	
	private Menu menu;
	private String title;
	
	public MenuState(String title) {
		this.title = title;
		
		this.menu = new Menu(new MenuItem[] {
				new MenuItem("Play", null),
				new MenuItem("Settings", null),
				new MenuItem("Exit", null)
			}
		);
	}
	
	@Override
	public void update() {
		menu.update();
	}

	@Override
	public void display(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString(title, Game.WIDTH / 2 - (g.getFontMetrics().stringWidth(title) /2 ), 
				Game.HEIGHT / 3);
	
		menu.display(g);
	}
	
	class Menu {
		MenuItem[] items;
		int choice;
		long timer = System.currentTimeMillis();
		
		Menu(MenuItem[] items) {
			this.items = items;
		}
		
		void update() {
			if(System.currentTimeMillis() - timer >= 100) {
				timer = System.currentTimeMillis();
				
				if(Game.getKeyInput().isKeyDown(KeyEvent.VK_W))
					choice--;
				if(Game.getKeyInput().isKeyDown(KeyEvent.VK_S))
					choice++;
				
				if(choice < 0) choice = (items.length - 1);
				if(choice > items.length - 1) choice = 0;
				
				for(int i = 0; i < items.length; i++) {
					if(i == choice)
						items[choice].selected = true;
					else 
						items[i].selected = false;
				}
			}
		}
		
		void display(Graphics g) {	
			for(int i = 0; i < items.length; i++) {
				MenuItem temp = items[i];
				
				if(temp.selected) {
					g.setColor(Color.BLUE);
				} else {
					g.setColor(Color.WHITE);
				}
				
				g.drawString(temp.text,
						Game.WIDTH / 2 - (g.getFontMetrics().stringWidth(temp.text) / 2), 
						(Game.HEIGHT / 3) + ((1+i) * g.getFontMetrics().getHeight()) + 3);
			}
		}
	}
	
	interface Function {
		void exec();
	}
	
	class MenuItem {
		String text;
		Function func;
		boolean selected;
		
		MenuItem(String text, Function func) {
			this.text = text;
			this.func = func;
		}
		
		void exec() {
			func.exec();
		}
	}
}