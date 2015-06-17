package dev.tilerpg.state;

import dev.tilerpg.gfx.Font;
import dev.tilerpg.gfx.Screen;
import dev.tilerpg.main.Game;
import dev.tilerpg.state.menu.Menu;
import dev.tilerpg.state.menu.MenuItem;

public class MainMenuState extends State {
	
	private Menu menu;
	private String title;
	
	public MainMenuState() {
		this.title = "Main Menu";
		
		this.menu = new Menu(new MenuItem[] {
				new MenuItem("Play", () -> Game.setState(new GameState())),
				new MenuItem("Settings", () -> Game.setState(new OptionState())),
				new MenuItem("Exit", () -> System.exit(0))
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
		Font.display(screen, title, (Game.WIDTH / 2 - (title.length() * 8) / 2) + ~(title.length() & 1)*-1, Game.HEIGHT / 4);
		menu.display(screen, Game.WIDTH / 2, Game.HEIGHT / 3);
	}
}