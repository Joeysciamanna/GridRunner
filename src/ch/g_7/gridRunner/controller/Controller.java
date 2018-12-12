package ch.g_7.gridRunner.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;


public class Controller implements Runnable, KeyListener{
	
	protected boolean run = true;
	
	protected Player player;
	protected KeySet keySet;

	protected boolean up;
	protected boolean left;
	protected boolean down;
	protected boolean right;
	
	protected static final int MIN_SPEED = 300;
	protected double speed = MIN_SPEED;
	protected double speedDec = 2.7;
	
	public Controller(Player player, KeySet keySet) {
		this.player = player;
		this.keySet = keySet;
	}
	

	
	@Override
	public void run() {
		while(run) {
			control();
			try {
				Thread.sleep((long) speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void control() {
		if(up) {
			player.moveUp(1);
		}
		if(left) {
			player.moveLeft(1);
		}
		if(down) {
			player.moveDown(1);
		}
		if(right) {
			player.moveRight(1);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {	
		int keyCode = e.getKeyCode();
		
		if(keySet.getUp() == keyCode) {
			up = true;
		}else if(keySet.getLeft() == keyCode) {
			left = true;
		}else if(keySet.getDown() == keyCode) {
			down = true;
		}else if(keySet.getRight() == keyCode) {
			right = true;
		}
		control();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keySet.getUp() == keyCode) {
			up = false;
		}else if(keySet.getLeft() == keyCode) {
			left = false;
		}else if(keySet.getDown() == keyCode) {
			down = false;
		}else if(keySet.getRight() == keyCode) {
			right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void setRun(boolean run) {
		this.run = run;
	}
}
