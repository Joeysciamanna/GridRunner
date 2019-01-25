package ch.g_7.gridRunner.server.lobby;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public class LobbyAgentImpl extends UnicastRemoteObject implements LobbyAgent{

	private static final long serialVersionUID = 3452675426926942222L;
	
	protected LobbyAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public LobbyData getLobbyDataFor(long lobbyId) {
		return LobbyProvider.getLobbyById(lobbyId).getLobbyData();
	}

	@Override
	public long joinGameLobby(GameCreationEvent event) throws RemoteException {
		return LobbyProvider.getLobbyFor(event).getId();
	}

}
