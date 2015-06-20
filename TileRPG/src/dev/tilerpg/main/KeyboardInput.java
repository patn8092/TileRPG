package dev.tilerpg.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
	
	private boolean[] keys;
	
	public static final int LEFT_ARROW = KeyEvent.VK_LEFT,
			RIGHT_ARROW = KeyEvent.VK_RIGHT,
			UP_ARROW = KeyEvent.VK_UP,
			DOWN_ARROW = KeyEvent.VK_DOWN;
	
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
	
	public boolean isKeyDown(char c) {
		return keys[new Character(c).hashCode()];
	}
}
