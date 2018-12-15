package ch.g_7.gridRunner.gameInstantiation;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JPanel;

import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.connection.ServerConnectionEstablisher;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.identification.ClientId;
import ch.g_7.gridRunner.identification.LocalClientId;
import ch.g_7.gridRunner.playerStatus.PlayerStatusApplier;
import ch.g_7.gridRunner.playerStatus.PlayerStatusSender;
import ch.g_7.gridRunner.server.game.GameAgent;
import ch.g_7.gridRunner.server.gameCreation.OnlineGameInstance;

public class GameRunner {

	private JPanel gamePanel;
	
	
	public void startNewGame(GameCreationEvent event) {
		
	}
	
	
	private GameInstace getNewLocalGame() {
		
		
	}
	

	private GameInstace getNewOnlineGame() {
		ExecutorService thread = Executors.newSingleThreadExecutor();
		Future<OnlineGameInstance> gameInstance = thread.submit(new Callable<OnlineGameInstance>() {
			@Override
			public OnlineGameInstance call() throws Exception { 
				GameAgent gameAgent = ServerConnectionEstablisher.getGameAgent();
				ClientId id = LocalClientId.getClientId();
				
				OnlineGameInstance onlineGameInstance = gameAgent.joinGameSession(id);
				while (onlineGameInstance == null) {
					onlineGameInstance = gameAgent.joinGameSession(id);
				}
				game.setGrid(new MapReader(new File("resources/maps/" + onlineGameInstance.getMap() + ".xml")).read());
				
				Player player = game.getPlayer(onlineGameInstance.getPlayerNr(id));
				player.setCleintId(id);
				game.addPlayerStatusWorker(new PlayerStatusSender(player, ServerConnectionEstablisher.getPlayerStatusAgent()));
				game.addController(new Controller(player, KeySet.WASD));
				
				Player villan = game.getPlayer(onlineGameInstance.getVillanNr(id));
				villan.setCleintId(onlineGameInstance.geVillanId(id));
				game.addPlayerStatusWorker(new PlayerStatusApplier(villan, ServerConnectionEstablisher.getPlayerStatusAgent()));
				return null;
			}
		});
	}
	
	
	public void setPanel(JPanel panel) {
		gamePanel = panel;
	}
}
