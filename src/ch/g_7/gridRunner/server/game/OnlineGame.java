package ch.g_7.gridRunner.server.game;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public class OnlineGame {

	private long gameId;
	
	public OnlineGame(GameCreationEvent event) {
		this.gameId = GameIdProvider.getNewId();
	}
	
	public void close() {
		GameIdProvider.setFree(gameId);
	}
	
	public long getId() {
		return gameId;
	}
}
