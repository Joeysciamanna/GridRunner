package ch.g_7.gridRunner.gameCreation;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.connection.ServerConnectionEstablisher;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.identification.ClientId;
import ch.g_7.gridRunner.identification.ClientIdProvider;
import ch.g_7.gridRunner.playerStatus.PlayerStatusApplier;
import ch.g_7.gridRunner.playerStatus.PlayerStatusSender;
import ch.g_7.gridRunner.server.game.GameAgent;

public class OnlineGameCreator extends GameCreator{

	public OnlineGameCreator(GameCreationEvent event) {
		super(event);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		try {
			GameInstace game = new GameInstace();
			
			OnlineGameData onlineGameInstance = null;
			ClientId id = ClientIdProvider.getClientId();
			GameAgent gameAgent = ServerConnectionEstablisher.getGameAgent();
			
			onlineGameInstance = gameAgent.joinGameSession(id);
			while (onlineGameInstance == null) {
				onlineGameInstance = gameAgent.joinGameSession(id);
			}
			
			game.setGrid(new MapReader(new File("resources/maps/" + onlineGameInstance.getMap() + ".xml")).read());
			
			for(Player p : game.getPlayers()) {
				if(p.getPlayerNr() == onlineGameInstance.getPlayerNr(id)) {
					System.out.println("Local Player: " + id.getId());
					p.setCleintId(id);
					game.addPlayerStatusWorker(new PlayerStatusSender(p, ServerConnectionEstablisher.getPlayerStatusAgent()));
					game.addController(new Controller(p, KeySet.WASD));
				}else {
					System.out.println("Remote Player: " + onlineGameInstance.getClientId(p.getPlayerNr()).getId());
					p.setCleintId(onlineGameInstance.getClientId(p.getPlayerNr()));
					game.addPlayerStatusWorker(new PlayerStatusApplier(p, ServerConnectionEstablisher.getPlayerStatusAgent()));
				}
			}
			this.game = game;
//			Player player = game.getPlayer(onlineGameInstance.getPlayerNr(id));
//			player.setCleintId(id);
//			game.addPlayerStatusWorker(new PlayerStatusSender(player, ServerConnectionEstablisher.getPlayerStatusAgent()));
//			game.addController(new Controller(player, KeySet.WASD));
//			
//			Player villan = game.getPlayer(onlineGameInstance.getVillanNr(id));
//			villan.setCleintId(onlineGameInstance.geVillanId(id));
//			game.addPlayerStatusWorker(new PlayerStatusApplier(villan, ServerConnectionEstablisher.getPlayerStatusAgent()));
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}



}
