package ch.g_7.gridRunner.game.creation.creator;

import java.io.File;
import java.io.IOException;

import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.bot.pathprovider.RefreshingSearchPathProvider;
import ch.g_7.gridRunner.bot.search.BreadthFirstSearcher;
import ch.g_7.gridRunner.bot.search.Coordinate;
import ch.g_7.gridRunner.bot.search.Searcher;
import ch.g_7.gridRunner.controller.BounceController;
import ch.g_7.gridRunner.controller.soft.KeyController;
import ch.g_7.gridRunner.controller.soft.PathFollowerController;
import ch.g_7.gridRunner.game.Game;
import ch.g_7.gridRunner.game.GameFitsException;
import ch.g_7.gridRunner.game.MapMetaData;
import ch.g_7.gridRunner.game.OfflineGame;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;
import ch.g_7.gridRunner.helper.KeySet;

public class OfflineGameCreator extends GameCreator<OfflineGame,GameCreationEvent>{

	private OfflineGame game;
	
	public OfflineGameCreator(GameCreationEvent event) {
		super(event);
		game = new OfflineGame();
	}


	protected void init() {
		KeyController keyController = new KeyController(game.getPlayer(1), KeySet.WASD);
		game.addListner(keyController);
		for(int i = 1; i<event.getPlayerCount(); i++) {
			RefreshingSearchPathProvider pathProvider = new RefreshingSearchPathProvider(new BreadthFirstSearcher(game.getGrid(), game.getPlayer(i+1), game.getPlayer(1)));
			PathFollowerController bot = new PathFollowerController(game.getPlayer(i+1),pathProvider);
			game.addStartable(pathProvider);
			game.addStartable(bot);
		}
	}

	
	
	public OfflineGame getGame() {
		return game;
	}
}
