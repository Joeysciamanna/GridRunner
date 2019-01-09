package ch.g_7.gridRunner.server.lobby;

public class LobbyStatusAgentImpl implements LobbyStatusAgent{

	private static final long serialVersionUID = 3452675426926942222L;

	@Override
	public LobbyData getLobbyDataFor(long lobbyId) {
		return LobbyProvider.getLobbyById(lobbyId).getLobbyData();
	}

}
