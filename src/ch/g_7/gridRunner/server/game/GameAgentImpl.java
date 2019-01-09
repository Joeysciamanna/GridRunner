package ch.g_7.gridRunner.server.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;
import ch.g_7.gridRunner.gameCreation.OnlineGameData;
import ch.g_7.gridRunner.server.lobby.LobbyProvider;

public class GameAgentImpl extends UnicastRemoteObject implements GameAgent {

	private static final long serialVersionUID = 1L;
	
	public GameAgentImpl() throws RemoteException {
		super();
	}
	
	@Override
	public synchronized long joinGameLobby(GameCreationEvent event) throws RemoteException {
		return LobbyProvider.getLobbyFor(event).getLobbyId();
	}

}
