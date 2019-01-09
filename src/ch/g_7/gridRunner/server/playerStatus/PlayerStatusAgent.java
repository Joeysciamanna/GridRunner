package ch.g_7.gridRunner.server.playerStatus;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.playerStatus.PlayerStatus;

public interface PlayerStatusAgent extends Remote, Serializable{

	public PlayerStatus getPlayerStatus(long id) throws RemoteException;
	
	public void setPlayerStatus(long id,PlayerStatus status) throws RemoteException;
}
