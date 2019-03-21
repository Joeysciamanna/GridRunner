package ch.g_7.gridRunner.server.game;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import ch.g_7.gridRunner.game.SimulatedGame;
import ch.g_7.gridRunner.game.creation.GameCreatorFactory;
import ch.g_7.gridRunner.game.creation.creator.GameCreator;
import ch.g_7.gridRunner.game.creation.creator.SimulatedGameCreator;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;
import ch.g_7.gridRunner.game.creation.event.OnlineGameCreationEvent;
import ch.g_7.gridRunner.server.IDProvider;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.player.VirtualPlayerAgentImpl;

public class GameAgentImpl extends Agent implements GameAgent{

	private Integer firstPlayer;
	private Integer secondPlayer;
	private SimulatedGame game;
	
	protected GameAgentImpl() throws RemoteException {}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public OnlineGameCreationEvent join(int clientId) throws RemoteException{
		if(firstPlayer==null) {
			firstPlayer = clientId;
		} else if (secondPlayer==null) {
			secondPlayer = clientId;
		} else {
			return getGame();
		}
		return null;
	}
	
	private OnlineGameCreationEvent getGame() {
		if(game==null) {
			GameCreator<SimulatedGame, GameCreationEvent> gameCreator = GameCreatorFactory.getGameCreatorFor(new GameCreationEvent("map1", 2, true, true));
			gameCreator.create();
			game = gameCreator.getGame();
			game.start();
		}
		Map<Integer,String> agents = new HashMap<>();
		for(VirtualPlayerAgentImpl agent : game.getAgends()) {
			agents.put(agent.getPlayerNr(), agent.getName());
		}
		return new OnlineGameCreationEvent("map1", 2, true, agents);
	}

}
