package ch.g_7.gridRunner.server.lobbyProvider;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.game.creation.event.ServersideGameCreationEvent;

public interface LobbyProviderAgent extends Remote, Serializable{

	public String join(ServersideGameCreationEvent event) throws RemoteException;
}
