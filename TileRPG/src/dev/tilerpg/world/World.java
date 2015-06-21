package dev.tilerpg.world;

import dev.tilerpg.entities.Player;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;
import dev.tilerpg.tile.*;

public class World {
	
	private int w, h;
	private Tile[] tiles;
	private Player player;
	
	public World(int w, int h) {
		this.w = w;
		this.h = h;
		player = new Player(Game.WIDTH/2, Game.HEIGHT/2);
	
		tiles = new Tile[w*h];
		
		for(int i = w; i >= 0; i--) {
			tiles[i+(h-2)*w] = new GrassBlock(i * 16, (h-2)*16);
		}
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
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i] != null) {
				tiles[i].display(screen);
			}
		}
		player.display(screen);
	}
}
