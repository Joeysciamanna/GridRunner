package ch.g_7.gridRunner.gameInstantiation;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JPanel;

import ch.g_7.gridEngine.helper.Lambda;
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
	private GameInstace game;
	private Lambda<Void, GameRunner> onActive;
	

	
	public void startNewGame(GameCreationEvent event) {
		if(event.isLocal()) {
			game = getNewLocalGame();
		}else {
			game = getNewOnlineGame();
		}
		game.activateControllers();
		onActive.apply(this);
		gamePanel.add(game.getGrid().getPanel());
		
	}

	private GameInstace getNewLocalGame() {
		GameInstace game = new GameInstace();
		game.setGrid(new MapReader(new File("resources/maps/" + "map1" + ".xml")).read());
		game.addController(new Controller(game.getPlayer(1), KeySet.WASD));
		game.addController(new Controller(game.getPlayer(2), KeySet.ARROW));
		return game;
	}

	private GameInstace getNewOnlineGame() {
		ClientId id = LocalClientId.getClientId();

		ExecutorService thread = Executors.newSingleThreadExecutor();
		Future<OnlineGameInstance> futureOnlineGameInstance = thread.submit(new Callable<OnlineGameInstance>() {
			@Override
			public OnlineGameInstance call() throws Exception {
				GameAgent gameAgent = ServerConnectionEstablisher.getGameAgent();

				OnlineGameInstance onlineGameInstance = gameAgent.joinGameSession(id);
				while (onlineGameInstance == null) {
					onlineGameInstance = gameAgent.joinGameSession(id);
				}
				return onlineGameInstance;
			}
		});
		OnlineGameInstance onlineGameInstance = null;
		try {
			onlineGameInstance = futureOnlineGameInstance.get();

			GameInstace game = new GameInstace();
			game.setGrid(new MapReader(new File("resources/maps/" + onlineGameInstance.getMap() + ".xml")).read());

			Player player = game.getPlayer(onlineGameInstance.getPlayerNr(id));
			player.setCleintId(id);
			game.addPlayerStatusWorker(
					new PlayerStatusSender(player, ServerConnectionEstablisher.getPlayerStatusAgent()));
			game.addController(new Controller(player, KeySet.WASD));

			Player villan = game.getPlayer(onlineGameInstance.getVillanNr(id));
			villan.setCleintId(onlineGameInstance.geVillanId(id));
			game.addPlayerStatusWorker(
					new PlayerStatusApplier(villan, ServerConnectionEstablisher.getPlayerStatusAgent()));
			return game;

		} catch (InterruptedException | ExecutionException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void onActive(Lambda<Void, GameRunner> l) {
		onActive = l;
	}
	

	public void setPanel(JPanel panel) {
		gamePanel = panel;
	}
	
	public GameInstace getGame() {
		return game;
	}
}
