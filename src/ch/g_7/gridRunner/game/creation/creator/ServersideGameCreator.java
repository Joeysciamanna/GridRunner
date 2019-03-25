package ch.g_7.gridRunner.game.creation.creator;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.game.ServersideGame;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;
import ch.g_7.gridRunner.server.player.PlayerAgentImpl;

public class ServersideGameCreator extends GameCreator<ServersideGame,GameCreationEvent> {

	private ServersideGame game;

	public ServersideGameCreator(GameCreationEvent event) {
		super(event);
		game = new ServersideGame();
	}

	@Override
	protected void init() {
		try {
			for (int i = 0; i < event.getPlayerCount(); i++) {
				PlayerAgentImpl playerAgent = new PlayerAgentImpl(game.getPlayer(i+1));
				game.addAgend(playerAgent);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ServersideGame getGame() {
		return game;
	}

}
