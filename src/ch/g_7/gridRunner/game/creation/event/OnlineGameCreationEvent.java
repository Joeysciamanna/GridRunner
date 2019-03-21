package ch.g_7.gridRunner.game.creation.event;

import java.util.Map;

public class OnlineGameCreationEvent extends GameCreationEvent{

	private Map<Integer, String> playerAgents;
	
	public OnlineGameCreationEvent(String map, int playerCount, boolean online, Map<Integer, String> playerAgents) {
		super(map, playerCount, online);
		this.playerAgents = playerAgents;
	}

	public Map<Integer, String> getPlayerAgents() {
		return playerAgents;
	}
}
