package ch.g_7.gridRunner.gameInstantiation;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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

public class GameCreator {

	public static GameInstace getNewGame(GameCreationEvent event) {
		GameInstace game = new GameInstace();

		if (event.isLocal()) {
			game.setGrid(new MapReader(new File("resources/maps/" + event.getMapName() + ".xml")).read());
			game.addController(new Controller(game.getPlayer(1), KeySet.WASD));
			game.addController(new Controller(game.getPlayer(2), KeySet.ARROW));
		} else {
			OnlineGameInstance onlineGameInstance = null;
			try {
				ClientId id = LocalClientId.getClientId();
				
				GameAgent gameAgent = ServerConnectionEstablisher.getGameAgent();
				
				onlineGameInstance = gameAgent.joinGameSession(id);
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
				
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
		}
		return game;
	}
}
