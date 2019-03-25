package ch.g_7.gridRunner.game.creation.creator;

import java.io.File;
import java.io.IOException;

import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.bot.pathprovider.RefreshingSearchPathProvider;
import ch.g_7.gridRunner.bot.search.BreadthFirstSearcher;
import ch.g_7.gridRunner.bot.search.Coordinate;
import ch.g_7.gridRunner.bot.search.Searcher;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.controller.bot.BounceController;
import ch.g_7.gridRunner.controller.bot.PathFollowerController;
import ch.g_7.gridRunner.controller.bot.creation.BotControllerFactory;
import ch.g_7.gridRunner.controller.human.KeyController;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Player;
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
		
		boolean playerSet = false;
		for(int i = 1; i<event.getPlayerCount(); i++) {
			Player player = game.getPlayer(i+1);
			if(!player.isBot() && !playerSet) {
				KeyController keyController = new KeyController(player, KeySet.WASD);
				game.addListner(keyController);
			} else if(player.isBot()){
				Controller<?> controller = BotControllerFactory.getBotController((Bot) player);
				game.addStartable((Bot) player);
				DO IT BETTER
			}
			
			
			RefreshingSearchPathProvider pathProvider = new RefreshingSearchPathProvider(new BreadthFirstSearcher(game.getGrid(), game.getPlayer(i+1), game.getPlayer(1)));
			PathFollowerController bot = new PathFollowerController(game.getPlayer(i+1),pathProvider);
			game.addStartable(pathProvider);
			
		}
	}

	
	
	public OfflineGame getGame() {
		return game;
	}
}
