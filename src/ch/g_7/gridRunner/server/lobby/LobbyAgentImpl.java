package ch.g_7.gridRunner.server.lobby;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ch.g_7.gridRunner.game.creation.event.ServersideGameCreationEvent;
import ch.g_7.gridRunner.server.IDProvider;
import ch.g_7.gridRunner.server.Server;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.game.GameAgentImpl;
import ch.g_7.logger.main.Level;

public class LobbyAgentImpl extends Agent implements LobbyAgent{

	private static final long serialVersionUID = 1391262368191247576L;
	
	private int id;
	private ServersideGameCreationEvent event;
	private ArrayList<Integer> clients;
	private GameAgentImpl gameAgent;
	
	public LobbyAgentImpl(ServersideGameCreationEvent event) throws RemoteException{
		clients = new ArrayList<>();
		this.event = event;
		id = IDProvider.getId(getClass().getName());
	}

	@Override
	public String getName() {
		return getClass().getSimpleName() +"-"+ id;
	}

	public synchronized boolean fits(ServersideGameCreationEvent event) {
		if(this.event.getPlayerCount() != event.getPlayerCount()) {
			return false;
		}
		if(!this.event.getMap().equals(event.getMap())) {
			return false;
		}
		return true;
	}
	

	public synchronized void add(int clientId) {
		LOGGER.log(Level.INFO, clientId + " joined the lobby");
		clients.add(clientId);
		if(clients.size() == event.getPlayerCount()) {
			start();
		}
	}
	
	@SuppressWarnings("unchecked")
	private synchronized void start() {
		try {
			LOGGER.log(Level.INFO, "Lobby started Game");
			gameAgent = new GameAgentImpl(event, (ArrayList<Integer>) clients.clone());
			Server.bind(gameAgent);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public synchronized LobbyData getLobbyData() {
		return new LobbyData(event, clients.size());
	}

	@Override
	public synchronized boolean hasStarted() {
		return gameAgent != null;
	}

	@Override
	public synchronized String getGameAgent(int clientId) {
		clients.remove(new Integer(clientId));
		return gameAgent.getName();
	}

}
