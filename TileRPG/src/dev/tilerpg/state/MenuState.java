package dev.tilerpg.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dev.tilerpg.gfx.Font;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;

public class MenuState extends State {
	
	private Menu menu;
	private String title;
	
	public MenuState(String title) {
		this.title = title;
		
		this.menu = new Menu(new MenuItem[] {
				new MenuItem("Play", () -> System.out.println("Play")),
				new MenuItem("Settings", () -> System.out.println("Settings")),
				new MenuItem("Exit", () -> System.out.println("Exit"))
			}
		);
	}
	
	@Override
	public void update() {
		menu.update();
	}

	@Override
	public void display(Screen screen) {
		Font.display(screen, title, Game.WIDTH / 2 - (title.length() * 8)/2, 0);
		//g.setColor(Color.WHITE);
		//g.drawString(title, 
				//Game.WIDTH / 2 - (g.getFontMetrics().stringWidth(title) / 2), 
				//Game.HEIGHT / 3);
	
		menu.display(screen);
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
				
				if(Game.getKeyInput().isKeyDown(KeyEvent.VK_ENTER)) {
					items[choice].exec();
				}
			}
		}
		
		void display(Screen screen) {	
			for(int i = 0; i < items.length; i++) {
				MenuItem temp = items[i];
				
				if(temp.selected) {
					//g.setColor(Color.BLUE);
				} else {
					//g.setColor(Color.WHITE);
				}
				
				//g.drawString(temp.text,
					//	Game.WIDTH / 2 - (g.getFontMetrics().stringWidth(temp.text) / 2), 
						//(Game.HEIGHT / 3) + ((1+i) * g.getFontMetrics().getHeight()) + 3);
			}
		}
	}
	
	interface Function {
		abstract void exec();
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