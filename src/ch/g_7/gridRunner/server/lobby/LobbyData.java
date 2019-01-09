package ch.g_7.gridRunner.server.lobby;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public class LobbyData {

	private GameCreationEvent event;
	private int actualPlayerCount;
	private boolean readyToStart;
	
	public LobbyData(GameCreationEvent event, int actualPlayerCount, boolean readyToStart) {
		this.event = event;
		this.actualPlayerCount = actualPlayerCount;
		this.readyToStart = readyToStart;
	}
	
	public GameCreationEvent getEvent() {
		return event;
	}
	public int getActualPlayerCount() {
		return actualPlayerCount;
	}
	public boolean isReadyToStart() {
		return readyToStart;
	}
	
}
