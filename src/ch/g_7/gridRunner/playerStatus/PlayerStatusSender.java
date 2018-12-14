package ch.g_7.gridRunner.playerStatus;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.server.playerStatus.PlayerStatusAgent;

public class PlayerStatusSender extends PlayerStatusWorker{

	
	public PlayerStatusSender(Player player, PlayerStatusAgent playerStatusAgent) {
		super(player, playerStatusAgent);
	}

	@Override
	public void run() {
		while(run) {
			try {
				playerStatusAgent.setPlayerStatus(player.getCleintId(), player.getPlayerStatus());
				Thread.sleep(20);
			} catch (RemoteException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	


	
	
}
