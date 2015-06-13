package dev.tilerpg.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
	
	private boolean[] keys;
	
	public KeyboardInput() {
		keys = new boolean[256];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode];
	}
}
