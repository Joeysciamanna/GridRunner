package ch.g_7.gridRunner.playerStatus;

import java.rmi.RemoteException;

import javax.swing.plaf.SliderUI;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.server.playerStatus.PlayerStatusAgent;

public class PlayerStatusApplier extends PlayerStatusWorker{

	
	public PlayerStatusApplier(Player player, PlayerStatusAgent playerStatusAgent) {
		super(player, playerStatusAgent);
	}
	
	@Override
	public void run() {
		while(run) {
			try {
				PlayerStatus status = playerStatusAgent.getPlayerStatus(player.getCleintId());
				if(status != null && status.isValid()) {
					player.setPlayerStatus(status);
				}
				Thread.sleep(20);
			} catch (RemoteException | InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
	
	
	

}
