package dev.tilerpg.state;

import dev.tilerpg.gfx.Font;
import dev.tilerpg.gfx.Screen;

public class GameState extends State {

	@Override
	public void update() {

	}

	@Override
	public void display(Screen screen) {
		Font.display(screen, "Game goes here", 0, 0);
	}

}
