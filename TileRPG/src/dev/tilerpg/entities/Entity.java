package dev.tilerpg.entities;

import dev.tilerpg.gfx.Image;

public abstract class Entity {
	
	protected int x, y, width, height;
	protected Image image;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
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
