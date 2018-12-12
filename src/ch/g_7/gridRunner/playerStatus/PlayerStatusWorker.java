package ch.g_7.gridRunner.playerStatus;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.server.playerStatus.PlayerStatusAgent;

public abstract class PlayerStatusWorker implements Runnable{

	protected boolean run = true;
	
	protected Player player;
	protected PlayerStatusAgent playerStatusAgent;
	
	
	public PlayerStatusWorker(Player player,PlayerStatusAgent playerStatusAgent) {
		this.player = player;
		this.playerStatusAgent = playerStatusAgent;
	}
	
	public void setRun(boolean run) {
		this.run = run;
	}
}
