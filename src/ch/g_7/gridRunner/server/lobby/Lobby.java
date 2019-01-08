package ch.g_7.gridRunner.server.lobby;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public class Lobby {

	private GameCreationEvent event;
	
	public Lobby(GameCreationEvent event) {
		this.event = event;
	}
	
	public boolean isMadeFor(GameCreationEvent event) {
		return true;
	}
}
