package dev.tilerpg.state;

import java.awt.Graphics;

import dev.tilerpg.util.FileUtils;

public abstract class State {
	
	public abstract void update();
	public abstract void display(Graphics g);
	
	public void saveState(String name) {
		if(name == null) name = "state";
		FileUtils.serializeTo(this, "/data/savestates/"+name+".sst");
	}
}
