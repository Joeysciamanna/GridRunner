package ch.g_7.gridRunner.gameCreation;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.PlayerKeyListner.KeyController;
import ch.g_7.gridRunner.PlayerKeyListner.LocalKeyController;
import ch.g_7.gridRunner.PlayerKeyListner.RemoteController;
import ch.g_7.gridRunner.connection.ServerConnectionEstablisher;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.id.LocalClientId;
import ch.g_7.gridRunner.server.game.GameAgent;
import ch.g_7.gridRunner.server.gameCreation.OnlineGameInstance;

public class GameCreator {

	public static GameInstace getNewGame(GameCreationEvent event) {
		GameInstace game = new GameInstace();

		if (event.isLocal()) {
			game.setGrid(new MapReader(new File("resources/maps/" + event.getMapName() + ".xml")).read());
			game.addController(new KeyController(game.getPlayer(1), KeySet.WASD));
			game.addController(new KeyController(game.getPlayer(2), KeySet.ARROW));
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
				game.addController(new LocalKeyController(player, KeySet.WASD, ServerConnectionEstablisher.getControllerAgent()));
				
				Player villan = game.getPlayer(onlineGameInstance.getVillanNr(id));
				villan.setCleintId(onlineGameInstance.geVillanId(id));
				game.addController(new RemoteController(player, ServerConnectionEstablisher.getControllerAgent()));
				
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
		}
		return game;
	}
}
