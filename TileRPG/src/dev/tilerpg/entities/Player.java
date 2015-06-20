package dev.tilerpg.entities;

import com.sun.prism.paint.Color;

import dev.tilerpg.gfx.Image;

public class Player extends Entity {

	public Player(int x, int y) {
		super(x, y);
		int[] p = new int[16*16];
		for(int i = 0; i < p.length; i++) {
			p[i] = Color.BLACK.hashCode();
		}
		image = new Image(p, 16, 16);
	}

}
