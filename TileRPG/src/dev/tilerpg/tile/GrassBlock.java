package dev.tilerpg.tile;

import dev.tilerpg.gfx.ExternalImageLoader;
import dev.tilerpg.gfx.Screen;

public class GrassBlock extends Tile {

	public GrassBlock(int x, int y) {
		super(x, y);
		image = ExternalImageLoader.load("/tile.png");
	}

	@Override
	public void update() {
	
	}

	@Override
	public void display(Screen screen) {
		screen.display(image, x, y);
	}

}
