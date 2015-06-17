package dev.tilerpg.state;

import dev.tilerpg.gfx.Font;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;
import dev.tilerpg.state.menu.Menu;
import dev.tilerpg.state.menu.MenuItem;

public class OptionState extends State {
	
	private Menu menu;
	
	public OptionState() {		
		this.menu = new Menu(new MenuItem[] {
				new MenuItem("Show FPS", () -> {}),
				new MenuItem("Music", () -> {}),
				new MenuItem("SFX", () -> {}),
				new MenuItem("Back", () -> {Game.setState(new MainMenuState());})
			}
		);
	}

	@Override
	public void update() {
		menu.update();
	}

	@Override
	public void display(Screen screen) {
		Font.setFont(Font.FONT1);
		Font.display(screen, "Options go here", 0, 0);
		menu.display(screen, Game.WIDTH / 2, 24);
	}
}
