package ch.g_7.gridRunner.helper;

import java.awt.event.KeyEvent;

public enum KeySet {
	WASD(KeyEvent.VK_W,KeyEvent.VK_A,KeyEvent.VK_S,KeyEvent.VK_D),
	ARROW(KeyEvent.VK_UP,KeyEvent.VK_LEFT,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT);
	
	
	private int up;
	private int left;
	private int down;
	private int right;
	
	private KeySet(int up,int left, int down, int right) {
		this.up = up;
		this.left = left;
		this.down = down;
		this.right = right;
	}
	
	public int getUp() {
		return up;
	}
	public int getLeft() {
		return left;
	}
	public int getDown() {
		return down;
	}
	public int getRight() {
		return right;
	}
	public static KeySet getKeySet(int n) {
		switch (n) {
		case 2:
			return ARROW; 
		default:
			return WASD;
		}
	}
}
