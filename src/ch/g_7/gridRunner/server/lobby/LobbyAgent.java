package ch.g_7.gridRunner.server.lobby;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LobbyAgent extends Remote, Serializable{

	public LobbyData getLobbyData() throws RemoteException;
	
	public boolean hasStarted() throws RemoteException;

	public String getGameAgent(int clientId) throws RemoteException;
	
}
