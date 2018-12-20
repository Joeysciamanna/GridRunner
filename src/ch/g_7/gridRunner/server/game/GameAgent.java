package ch.g_7.gridRunner.server.game;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.gameCreation.OnlineGameData;
import ch.g_7.gridRunner.identification.ClientId;

public interface GameAgent extends Remote, Serializable{

	public OnlineGameData joinGameSession(ClientId id) throws RemoteException;
	
}
