package ch.g_7.gridRunner.server.game;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ch.g_7.gridRunner.game.ServersideGame;
import ch.g_7.gridRunner.game.creation.GameCreatorFactory;
import ch.g_7.gridRunner.game.creation.creator.GameCreator;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;
import ch.g_7.gridRunner.game.creation.event.OnlineGameCreationEvent;
import ch.g_7.gridRunner.game.creation.event.ServersideGameCreationEvent;
import ch.g_7.gridRunner.server.IDProvider;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.player.PlayerAgentImpl;
import ch.g_7.logger.main.Level;

public class GameAgentImpl extends Agent implements GameAgent{

	private static final long serialVersionUID = 3086186302338477220L;
	
	private int id;
	private ServersideGame game;
	private ServersideGameCreationEvent event;
	private ArrayList<Integer> clients;
	private int startRequests;
	
	public GameAgentImpl(ServersideGameCreationEvent event, ArrayList<Integer> clients) throws RemoteException {
		init(event);
		id = IDProvider.getId(getClass().getName());
		this.clients = clients;
		this.event = event;
	}
	
	private synchronized void init(ServersideGameCreationEvent event) {
		GameCreator<?, ?> gameCreator = GameCreatorFactory.getGameCreatorFor(event);
		gameCreator.create();
		game = (ServersideGame) gameCreator.getGame();
		game.bind();
	}

	@Override
	public String getName() {
		return getClass().getSimpleName()+"-"+id;
	}

	@Override
	public synchronized OnlineGameCreationEvent getGame(int clientId) throws RemoteException {
		Map<Integer, String> playerAgents = new HashMap<>();
		for(PlayerAgentImpl agent : game.getAgends()) {
			playerAgents.put(agent.getPlayerNr(), agent.getName());
		}
		LOGGER.log(Level.INFO, "Client " + clientId + " got the game, and plays with " + clients + " as " + playerAgents.keySet().toArray(new Integer[0])[clients.indexOf(clientId)]);
		return new OnlineGameCreationEvent(event.getMap(), event.getPlayerCount(), true, playerAgents, playerAgents.keySet().toArray(new Integer[0])[clients.indexOf(clientId)]);
	}
	

	@Override
	public void start() throws RemoteException {
		startRequests++;
		if(startRequests==clients.size()) {
			game.start();
		}
	}

}
