package dev.tilerpg.entities;

import java.awt.Color;

import dev.tilerpg.gfx.Image;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;

public class Player extends Entity {

	public Player(int x, int y) {
		super(x, y);
		int[] p = new int[16*16];
		for(int i = 0; i < p.length; i++) {
			p[i] = Color.BLACK.getRGB();
		}
		image = new Image(p, 16, 16);
	}
	
	@Override
	public void update() {
		if(Game.getKeyInput().isKeyDown('W'))
			y--;
		else if(Game.getKeyInput().isKeyDown('S'))
			y++;
		
		if(Game.getKeyInput().isKeyDown('A'))
			x--;
		else if(Game.getKeyInput().isKeyDown('D'))
			x++;
	}

	@Override
	public void display(Screen screen) {
		screen.display(image, x, y);
	}

}
