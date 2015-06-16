package dev.tilerpg.state.menu;

public class MenuItem {
	String text;
	Function func;
	boolean selected;
	
	public MenuItem(String text, Function func) {
		this.text = text;
		this.func = func;
	}
	
	public void exec() {
		func.exec();
	}
}
