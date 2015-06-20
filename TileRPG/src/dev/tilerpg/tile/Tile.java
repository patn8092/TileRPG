package dev.tilerpg.tile;

import java.awt.Rectangle;

import dev.tilerpg.gfx.Image;
import dev.tilerpg.gfx.Screen;

public abstract class Tile {
	
	protected int x, y;
	protected Image image;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	
	public abstract void display(Screen screen);
	
	public Rectangle getBounds() {
		return new Rectangle(
				x, y,
				image.w, image.h
				);
	}
}
