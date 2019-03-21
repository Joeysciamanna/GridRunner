package ch.g_7.gridRunner.game;

import ch.g_7.gridEngine.stream.MetaInfo;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;

public class MapMetaData extends MetaInfo {

	private boolean online;
	private boolean offline;
	private int maxPlayers;
	private int minPlayers;

	@Override
	public void set(String key, String value) {
		switch (key) {
		case "online":
			online = value == "true";
			break;
		case "offline":
			offline = value == "true";
			break;
		case "maxPlayers":
			maxPlayers = Integer.valueOf(value);
		case "minPlayers":
			minPlayers = Integer.valueOf(value);
		default:
			super.set(key, value);
		}
	}

	public boolean fits(GameCreationEvent event) {
		if(event.isOnline() && !online) {
			return false;
		}
		if(!event.isOnline() && !offline) {
			return false;
		}
		if(event.getPlayerCount()<minPlayers) {
			return false;
		}
		if(event.getPlayerCount()>maxPlayers) {
			return false;
		}
		return true;
	}
	
	public boolean isOnline() {
		return online;
	}

	public boolean isOffline() {
		return offline;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

}
