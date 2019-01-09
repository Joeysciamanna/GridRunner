package ch.g_7.gridRunner.server.lobby;

import java.util.ArrayList;
import java.util.Iterator;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public class Lobby {

	private GameCreationEvent event;
	private long lobbyId;
	private ArrayList<Long> players;
	private boolean full;
	
	public Lobby(GameCreationEvent event) {
		this.event = event;
		this.players = new ArrayList<>();
	}
	
	public boolean isMadeFor(GameCreationEvent e) {
		return (event.getPlayerCount()==e.getPlayerCount() && event.getMapName().equals(e.getMapName()) && !full);
	}
	
	public long getLobbyId() {
		return lobbyId;
	}
	
	public LobbyData getLobbyData() {
		return new LobbyData(event, getPlayerCount(), full);
	}
	
	public synchronized void addPlayer(long id) {
		players.add(id);
		chekToStart();
	}
	
	public synchronized void removePlayer(long id) {
		players.remove(id);
		chekToStart();
	}
	
	public int getPlayerCount() {
		return players.size(); 
	}

	public void chekToStart() {
		if (players.size() >= event.getPlayerCount()) {
			full = true;
		}
	}
}
