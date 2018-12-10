package ch.g_7.gridRunner.server.playerStatus;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.playerStatus.PlayerStatus;

public interface PlayerStatusAgent extends Remote, Serializable{

	public PlayerStatus getPlayerStatus(ClientId client) throws RemoteException;
	
	public void setPlayerStatus(ClientId client,PlayerStatus status) throws RemoteException;
}
