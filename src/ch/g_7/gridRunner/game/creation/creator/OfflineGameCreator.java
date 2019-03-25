package ch.g_7.gridRunner.game.creation.creator;

import ch.g_7.gridRunner.controller.bot.BotController;
import ch.g_7.gridRunner.controller.bot.creation.BotControllerFactory;
import ch.g_7.gridRunner.controller.human.KeyController;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Player;
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
		
		for(int i = 0; i<event.getPlayerCount(); i++) {
			Player player = game.getPlayer(i+1);
			if(!player.isBot() && !playerSet) {
				KeyController keyController = new KeyController(player, KeySet.WASD);
				game.addListner(keyController);
				playerSet = true;
				game.setPlayerAsUsed(i+1);
			} else if(player.isBot()){
				BotController<?> controller = BotControllerFactory.getBotController((Bot) player);
				game.addStartable(controller);
				game.setPlayerAsUsed(i+1);
			}
		}
		game.removeUnUsedPlayers();
	}

	
	
	public OfflineGame getGame() {
		return game;
	}
}
