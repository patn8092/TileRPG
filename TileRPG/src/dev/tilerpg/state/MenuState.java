package dev.tilerpg.state;

import java.awt.Color;
import java.awt.Graphics;

import dev.tilerpg.main.Game;

public class MenuState extends State {
	
	private Menu menu;
	private String title;
	
	public MenuState(String title) {
		this.title = title;
		
		this.menu = new Menu(new MenuItem[] {
				new MenuItem("Play", new Function() {

					@Override
					public void exec() {
						Game.setState(new GameState());
					}
				}),
				
			}
		);
	}
	
	@Override
	public void update() {
		
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
		
		Menu(MenuItem[] items) {
			this.items = items;
		}
		
		void display(Graphics g) {
			
		}
	}
	
	interface Function {
		void exec();
	}
	
	class MenuItem {
		String text;
		Function func;
		
		MenuItem(String text, Function func) {
			this.text = text;
			this.func = func;
		}
		
		void exec() {
			func.exec();
		}
	}
}
