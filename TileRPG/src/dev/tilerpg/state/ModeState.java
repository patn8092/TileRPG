package dev.tilerpg.state;

import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;
import dev.tilerpg.state.menu.Menu;
import dev.tilerpg.state.menu.MenuItem;

public class ModeState extends State {
	
	private Menu menu;
	
	public ModeState() {

		this.menu = new Menu(new MenuItem[] {
			new MenuItem("New Game", () -> {}),
			new MenuItem("Load Game", () -> {}),
			new MenuItem("Host multiplayer", () -> {}),
			new MenuItem("Join multiplayer", () -> {}),
			new MenuItem("Back", () -> {})
		});
	}
	
	@Override
	public void update() {
		menu.update();
	}

	@Override
	public void display(Screen screen) {
		menu.display(screen, Game.WIDTH/2, Game.HEIGHT/5);
	}

}
