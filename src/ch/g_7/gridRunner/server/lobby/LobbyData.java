package ch.g_7.gridRunner.server.lobby;

import java.io.Serializable;

import ch.g_7.gridRunner.game.creation.event.ServersideGameCreationEvent;

public class LobbyData implements Serializable{

<<<<<<< HEAD
	private GameCreationEvent event;
	private int actualPlayerCount;
	private long gameId;
	private ArrayList<Long> players;
=======
	private static final long serialVersionUID = 120988460011111676L;
>>>>>>> branch 'master' of https://github.com/Joeysciamanna/GridRunner.git
	
<<<<<<< HEAD
	public LobbyData(GameCreationEvent event, int actualPlayerCount, long gameId,ArrayList<Long> players) {
=======
	private ServersideGameCreationEvent event;
	private int playerJoined;
	
	public LobbyData(ServersideGameCreationEvent event, int playerJoined) {
>>>>>>> branch 'master' of https://github.com/Joeysciamanna/GridRunner.git
		this.event = event;
<<<<<<< HEAD
		this.actualPlayerCount = actualPlayerCount;
		this.gameId = gameId;
		this.players = players;
=======
		this.playerJoined = playerJoined;
>>>>>>> branch 'master' of https://github.com/Joeysciamanna/GridRunner.git
	}
	
	public int getPlayerJoined() {
		return playerJoined;
	}
	
	public ServersideGameCreationEvent getEvent() {
		return event;
	}
<<<<<<< HEAD
	public int getActualPlayerCount() {
		return actualPlayerCount;
	}
	public boolean isReadyToStart() {
		return gameId!=0;
	}
	
=======
>>>>>>> branch 'master' of https://github.com/Joeysciamanna/GridRunner.git
}
