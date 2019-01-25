package ch.g_7.gridRunner.server.game;

import java.util.ArrayList;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;
import ch.g_7.gridRunner.server.lobby.Lobby;


public class GameProvider {

	private static ArrayList<OnlineGame> games = new ArrayList<>();

	public static long createGame(GameCreationEvent event, Lobby lobby) {
		OnlineGame game = new OnlineGame(event);
		games.add(game);
		return game.getId();
	}
	
	public static void removeGame(long lobbyId) {
		games.remove(getGameById(lobbyId));
	}

	public static OnlineGame getGameById(long lobbyId) {
		for(OnlineGame game : games) {
			if(game.getId() == lobbyId) {
				return game;
			}
		}
		return null;
	}
}
