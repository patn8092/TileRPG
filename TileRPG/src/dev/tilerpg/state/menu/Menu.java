package dev.tilerpg.state.menu;

import dev.tilerpg.gfx.Font;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;
import dev.tilerpg.main.KeyboardInput;

public class Menu {
	MenuItem[] items;
	int choice;
	long timer = System.currentTimeMillis();
	
	public Menu(MenuItem[] items) {
		this.items = items;
	}
	
	public void update() {
		if(System.currentTimeMillis() - timer >= 95) {
			timer = System.currentTimeMillis();
			
			if(Game.getKeyInput().isKeyDown(KeyboardInput.UP_ARROW))
				choice--;
			if(Game.getKeyInput().isKeyDown(KeyboardInput.DOWN_ARROW))
				choice++;
			
			if(choice < 0) choice = (items.length - 1);
			if(choice > items.length - 1) choice = 0;
			
			for(int i = 0; i < items.length; i++) {
				if(i == choice)
					items[choice].selected = true;
				else 
					items[i].selected = false;
			}
			
			if(Game.getKeyInput().isKeyDown(' ')) {
				items[choice].exec();
			}
		}
	}
	
	public void display(Screen screen, int x, int y) {	
		for(int i = 0; i < items.length; i++) {
			MenuItem temp = items[i];
			
			if(temp.selected) {
				Font.setFont(Font.FONT2);
			} else {
				Font.setFont(Font.FONT1);
			}
			
			Font.display(screen, temp.text, x - (temp.text.length() * 8) / 2, 
					y + (1+i)*24
					);
		}
	}
}

