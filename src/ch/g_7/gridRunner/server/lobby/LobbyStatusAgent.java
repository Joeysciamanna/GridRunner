package ch.g_7.gridRunner.server.lobby;

import java.io.Serializable;
import java.rmi.Remote;

public interface LobbyStatusAgent extends Remote, Serializable{

	public LobbyData getLobbyDataFor(long lobbyId);
	
}
