package ch.g_7.gridRunner.PlayerKeyListner;

import ch.g_7.gridRunner.fields.Player;


public abstract class PlayerController implements Runnable{
	
	protected boolean run = true;
	
	protected Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	
	public void setRun(boolean run) {
		this.run = run;
	}
	
}
