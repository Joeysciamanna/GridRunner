package ch.g_7.gridRunner.server.lobby;

import java.util.ArrayList;

import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public class LobbyData {

	private GameCreationEvent event;
	private int actualPlayerCount;
	private boolean readyToStart;
	private long gameId;
	private ArrayList<Long> players;
	
	public LobbyData(GameCreationEvent event, int actualPlayerCount, boolean readyToStart, long gameId,ArrayList<Long> players) {
		this.event = event;
		this.actualPlayerCount = actualPlayerCount;
		this.readyToStart = readyToStart;
		this.gameId = gameId;
		this.players = players;
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
