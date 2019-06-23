package ch.g_7.gridRunner.game.creation.creator;

import ch.g_7.gridRunner.controller.bot.BotController;
import ch.g_7.gridRunner.controller.bot.creation.BotControllerFactory;
import ch.g_7.gridRunner.controller.human.KeyController;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Player;
import ch.g_7.gridRunner.field.spawn.Spawn;
import ch.g_7.gridRunner.field.spawn.SpawnData;
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
		
		for(int i = 1; i<=event.getPlayerCount(); i++) {
			SpawnData spawnData = game.getSpawn(i).getSpawnData();
			if(spawnData.isPlayer() && !playerSet) {
				Player player = new Player(i);
				game.addPlayer(player, spawnData.getPosition());
				KeyController keyController = new KeyController(player, KeySet.WASD);
				game.addListner(keyController);
				playerSet = true;
			} else if(spawnData.isBot()){
				Bot bot = new Bot(i, spawnData.getBotController());
				game.addPlayer(bot, spawnData.getPosition());
				BotController controller = BotControllerFactory.getBotController(spawnData.getBotController(), bot, game.getGrid());
				game.addStartable(controller);
			}
		}
	}

	
	
	public OfflineGame getGame() {
		return game;
	}
}
