package dev.tilerpg.state;

import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;
import dev.tilerpg.state.menu.Menu;
import dev.tilerpg.state.menu.MenuItem;

public class ModeState extends State {
	
	private Menu menu;
	
	public ModeState() {

		this.menu = new Menu(new MenuItem[] {
			new MenuItem("New Game", () -> {Game.setState(new GameState());}),
			new MenuItem("Load Game", () -> {}),
			new MenuItem("Host multiplayer", () -> {}),
			new MenuItem("Join multiplayer", () -> {}),
			new MenuItem("Back", () -> {Game.setState(new MainMenuState());})
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
