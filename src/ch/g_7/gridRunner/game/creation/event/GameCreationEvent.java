package ch.g_7.gridRunner.game.creation.event;

import java.io.Serializable;

import ch.g_7.gridRunner.game.MapMetaData;

public class GameCreationEvent implements Serializable{

	private String map;
	private int playerCount;
	private boolean online;
	private boolean simulated;
	
	public GameCreationEvent(String map, int playerCount, boolean online) {
		this(map, playerCount, online, false);
	}

	public GameCreationEvent(String map, int playerCount, boolean online, boolean simulated) {
		this.map = map;
		this.playerCount = playerCount;
		this.online = online;
		this.simulated = false;
	}
	
	public String getMap() {
		return map;
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public boolean isOnline() {
		return online;
	}

	public boolean isSimulated() {
		return simulated;
	}
	
}
