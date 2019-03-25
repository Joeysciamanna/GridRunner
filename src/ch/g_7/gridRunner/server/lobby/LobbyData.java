package ch.g_7.gridRunner.server.lobby;

import java.io.Serializable;

import ch.g_7.gridRunner.game.creation.event.ServersideGameCreationEvent;

public class LobbyData implements Serializable{

	private static final long serialVersionUID = 120988460011111676L;
	
	private ServersideGameCreationEvent event;
	private int playerJoined;
	
	public LobbyData(ServersideGameCreationEvent event, int playerJoined) {
		this.event = event;
		this.playerJoined = playerJoined;
	}
	
	public int getPlayerJoined() {
		return playerJoined;
	}
	
	public ServersideGameCreationEvent getEvent() {
		return event;
	}
}
