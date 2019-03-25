package ch.g_7.gridRunner.game.creation.event;

import java.util.Map;

public class OnlineGameCreationEvent extends GameCreationEvent{

	private Map<Integer, String> playerAgents;
	private int playerNr;
	
	public OnlineGameCreationEvent(String map, int playerCount, boolean online, Map<Integer, String> playerAgents, int playerNr) {
		super(map, playerCount, online);
		this.playerAgents = playerAgents;
		this.playerNr = playerNr;
	}

	public Map<Integer, String> getPlayerAgents() {
		return playerAgents;
	}

	public int getPlayerNr() {
		return playerNr;
	}
}
