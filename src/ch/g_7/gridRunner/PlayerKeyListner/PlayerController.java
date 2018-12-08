package ch.g_7.gridRunner.PlayerKeyListner;

import ch.g_7.gridRunner.fields.Player;


public abstract class PlayerController implements Runnable{
	
	protected boolean run = true;
	
	protected static final int MIN_SPEED = 300;
	protected double speed = MIN_SPEED;
	protected double speedDec = 2.7;
	
	protected Player player;
	
	protected boolean up;
	protected boolean left;
	protected boolean down;
	protected boolean right;
	
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
	
	public PlayerController(Player player) {
		this.player = player;
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
	
	public void setRun(boolean run) {
		this.run = run;
	}
	
}
