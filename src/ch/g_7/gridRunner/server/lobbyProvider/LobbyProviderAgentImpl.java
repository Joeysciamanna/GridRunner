package ch.g_7.gridRunner.server.lobbyProvider;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ch.g_7.gridRunner.game.creation.event.ServersideGameCreationEvent;
import ch.g_7.gridRunner.server.Server;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.agent.Agents;
import ch.g_7.gridRunner.server.lobby.LobbyAgentImpl;
import ch.g_7.logger.main.Level;

public class LobbyProviderAgentImpl extends Agent implements LobbyProviderAgent{

	private static final long serialVersionUID = 1871051353398282213L;
	
	private ArrayList<LobbyAgentImpl> lobbys;
	
	public LobbyProviderAgentImpl() throws RemoteException {
		lobbys = new ArrayList<>();
	}

	@Override
	public String getName() {
		return Agents.LOBBY_PROVIDER.toString();
	}

	@Override
	public synchronized String join(ServersideGameCreationEvent event) throws RemoteException{
		for (LobbyAgentImpl lobby : lobbys) {
			if(lobby.fits(event)) {
				lobby.add(event.getClientId());
				if(lobby.hasStarted()) {
					lobbys.remove(lobby);
				}
				return lobby.getName();
			}
		}
		LobbyAgentImpl newLobby = new LobbyAgentImpl(event);
		LOGGER.log(Level.INFO,"New Lobby created");
		Server.bind(newLobby);
		lobbys.add(newLobby);
		newLobby.add(event.getClientId());
		return newLobby.getName();

	}
}
