package ch.g_7.gridRunner.server.lobby;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public interface LobbyAgent extends Remote, Serializable{

	public long joinGameLobby(GameCreationEvent event) throws RemoteException;
	
	public LobbyData getLobbyDataFor(long lobbyId);
	
}
