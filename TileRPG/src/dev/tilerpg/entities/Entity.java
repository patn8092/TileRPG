package dev.tilerpg.entities;

import dev.tilerpg.gfx.Image;
import dev.tilerpg.gfx.Screen;

public abstract class Entity {
	
	protected int x, y, width, height;
	protected Image image;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	
	public abstract void display(Screen screen);
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
