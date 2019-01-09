package ch.g_7.gridRunner.server.game;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import ch.g_7.gridRunner.gameCreation.GameCreationEvent;
import ch.g_7.gridRunner.gameCreation.OnlineGameData;

public interface GameAgent extends Remote, Serializable{

	public long joinGameLobby(GameCreationEvent event) throws RemoteException;
	
}
