package ch.g_7.gridRunner.game.creation.creator;

import ch.g_7.gridRunner.connection.ServerConnectionProvider;
import ch.g_7.gridRunner.controller.SynchronizedController;
import ch.g_7.gridRunner.controller.human.VirtualKeyController;
import ch.g_7.gridRunner.game.OnlineGame;
import ch.g_7.gridRunner.game.creation.event.OnlineGameCreationEvent;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.server.player.PlayerAgent;

public class OnlineGameCreator extends GameCreator<OnlineGame, OnlineGameCreationEvent>{

	private OnlineGame game;
	
	public OnlineGameCreator(OnlineGameCreationEvent event) {
		super(event);
		game = new OnlineGame();
	}

	@Override
	protected void init() {
		VirtualKeyController keyController = new VirtualKeyController(getAgentForLocalPlayer(), KeySet.WASD);
		game.addListner(keyController);
		for(int i = 0; i<event.getPlayerCount(); i++) {
			PlayerAgent playerAgent = (PlayerAgent) ServerConnectionProvider.lookup(event.getPlayerAgents().get(i+1));
			SynchronizedController synchronizedController = new SynchronizedController(game.getPlayer(i+1), playerAgent);
			game.addStartable(synchronizedController);
		}
	}

	private PlayerAgent getAgentForLocalPlayer() {
		return (PlayerAgent) ServerConnectionProvider.lookup(event.getPlayerAgents().get(event.getPlayerNr()));
	}
	
	@Override
	public OnlineGame getGame() {
		return game;
	}

}
