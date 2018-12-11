package ch.g_7.gridRunner.server.game;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.identification.ClientId;
import ch.g_7.gridRunner.server.gameCreation.OnlineGameInstance;

public interface GameAgent extends Remote, Serializable{

	public OnlineGameInstance joinGameSession(ClientId id) throws RemoteException;
	
}
