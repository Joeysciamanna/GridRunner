package ch.g_7.gridRunner.game.creation.creator;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.bot.pathprovider.RefreshingSearchPathProvider;
import ch.g_7.gridRunner.bot.search.BreadthFirstSearcher;
import ch.g_7.gridRunner.controller.soft.KeyController;
import ch.g_7.gridRunner.controller.soft.PathFollowerController;
import ch.g_7.gridRunner.game.Game;
import ch.g_7.gridRunner.game.SimulatedGame;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.server.player.VirtualPlayerAgentImpl;

public class SimulatedGameCreator extends GameCreator<SimulatedGame,GameCreationEvent> {

	private SimulatedGame game;

	public SimulatedGameCreator(GameCreationEvent event) {
		super(event);
		game = new SimulatedGame();
	}

	@Override
	protected void init() {
		try {
			VirtualPlayerAgentImpl playerAgent = new VirtualPlayerAgentImpl(game.getPlayer(1));
			game.addAgend(playerAgent);
			for (int i = 1; i < event.getPlayerCount(); i++) {
				RefreshingSearchPathProvider pathProvider = new RefreshingSearchPathProvider(new BreadthFirstSearcher(game.getGrid(), game.getPlayer(i + 1), game.getPlayer(1)));
				PathFollowerController bot = new PathFollowerController(game.getPlayer(i + 1), pathProvider);
				playerAgent = new VirtualPlayerAgentImpl(game.getPlayer(i+1));
				game.addAgend(playerAgent);
				game.addStartable(pathProvider);
				game.addStartable(bot);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SimulatedGame getGame() {
		return game;
	}

}
