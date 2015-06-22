package dev.tilerpg.state;

import dev.tilerpg.gfx.Font;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;
import dev.tilerpg.world.World;

public class GameState extends State {
	
	private World world;
	
	public GameState() {
		world = new World(Game.WIDTH / 16, (Game.HEIGHT / 16) + 1);
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
