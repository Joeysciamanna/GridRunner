package ch.g_7.gridRunner.server.lobby;

import java.util.ArrayList;
import java.util.Iterator;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;
import ch.g_7.gridRunner.server.game.GameProvider;

public class Lobby {

	private GameCreationEvent event;
	private long lobbyId;
	private ArrayList<Long> players;
	private boolean closed;
	private long gameId;
	
	public Lobby(GameCreationEvent event) {
		this.event = event;
		this.players = new ArrayList<>();
		this.lobbyId = LobbyIdProvider.getNewId();
	}
	
	public boolean isMadeFor(GameCreationEvent e) {
		return (event.getPlayerCount()==e.getPlayerCount() && event.getMapName().equals(e.getMapName()) && !closed);
	}
	
	public long getId() {
		return lobbyId;
	}
	
	public LobbyData getLobbyData() {
		return new LobbyData(event, getPlayerCount(), gameId, players);
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
			closed = true;
			gameId = GameProvider.createGame(event,this);
		}
	}
	
	public void close() {
		LobbyProvider.removeLobby(lobbyId);
		LobbyIdProvider.setFree(lobbyId);
	}
	
}
