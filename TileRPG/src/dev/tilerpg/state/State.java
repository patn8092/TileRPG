package dev.tilerpg.state;

import dev.tilerpg.gfx.Screen;
import dev.tilerpg.util.FileUtils;

public abstract class State {
	
	public abstract void update();
	public abstract void display(Screen screen);
	
	public void saveState(String name) {
		if(name == null) name = "state";
		FileUtils.serializeTo(this, "/data/savestates/"+name+".sst");
	}
}
