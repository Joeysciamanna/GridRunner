package ch.g_7.gridRunner.server.lobby;

import java.util.ArrayList;

import ch.g_7.gridRunner.gameCreation.GameCreationEvent;

public class LobbyProvider {
	
	private static ArrayList<Lobby> lobbies = new ArrayList<>();

	public static Lobby getLobbyFor(GameCreationEvent event) {
		for(Lobby lobby : lobbies) {
			if(lobby.isMadeFor(event)) {
				return lobby;
			}
		}
		Lobby newLobby = new Lobby(event);
		lobbies.add(newLobby);
		return newLobby;
	}
	
	public static Lobby getLobbyById(long lobbyId) {
		for(Lobby lobby : lobbies) {
			if(lobby.getId() == lobbyId) {
				return lobby;
			}
		}
		return null;
	}
	
	public static void removeLobby(long lobbyId) {
		lobbies.remove(getLobbyById(lobbyId));
	}
}
