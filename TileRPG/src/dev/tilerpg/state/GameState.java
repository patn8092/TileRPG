package dev.tilerpg.state;

import dev.tilerpg.gfx.Font;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.world.World;

public class GameState extends State {
	
	private World world;
	
	public GameState() {
		world = new World(10, 10);
	}
	
	@Override
	public void update() {
		world.update();
	}

	@Override
	public void display(Screen screen) {
		Font.display(screen, "Game goes here", 0, 0);
		world.display(screen);
	}

}
