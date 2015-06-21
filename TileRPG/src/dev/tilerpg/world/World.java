package dev.tilerpg.world;

import dev.tilerpg.entities.Player;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;

public class World {
	
	private int w, h;
	//private Tile[] tiles;
	private Player player;
	
	public World(int w, int h) {
		this.w = w;
		this.h = h;
		
		player = new Player(Game.WIDTH/2, Game.HEIGHT/2);
	}
	
	public void update() {
		player.update();
	}
	
	public void display(Screen screen) {
		/*
		int xMin, xMax, yMin, yMax;
		
		for(int y = yMin; y < yMax; y++) {
			for(int x = xMin; x < xMax; x++) {
				
			}
		}
		*/
		player.display(screen);
	}
}
