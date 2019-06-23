package ch.g_7.gridRunner.main;

import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridRunner.connection.ClientIdProvider;
import ch.g_7.gridRunner.connection.ServerConnectionProvider;
import ch.g_7.gridRunner.field.creation.GridRunnerFieldFactory;
import ch.g_7.gridRunner.game.OfflineGame;
import ch.g_7.gridRunner.game.OnlineGame;
import ch.g_7.gridRunner.game.creation.GameCreatorFactory;
import ch.g_7.gridRunner.game.creation.creator.GameCreator;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;
import ch.g_7.gridRunner.game.creation.event.OnlineGameCreationEvent;
import ch.g_7.gridRunner.game.creation.event.ServersideGameCreationEvent;
import ch.g_7.gridRunner.server.clientId.ClientIdProviderAgent;
import ch.g_7.gridRunner.server.game.GameAgent;
import ch.g_7.gridRunner.server.lobby.LobbyAgent;
import ch.g_7.gridRunner.server.lobbyProvider.LobbyProviderAgent;

public class GridRunner {
	
	public static void main(String[] args) throws RemoteException {

		
		FieldCreationRegister.setDefaultFactory(new GridRunnerFieldFactory());

		

		OfflineGame game = initOffline();
		//OnlineGame game = initOnline();
		
		
		game.getGrid().setSize(new Dimension(600, 600));
		JFrame window = new JFrame();
		for (KeyListener listener : game.getListeners()) {
			window.addKeyListener(listener);
		}
		JPanel gridPanel = game.getGrid().getPanel();
		gridPanel.setLocation(0,0);
		window.add(gridPanel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
		
		
		new Timer().schedule( new TimerTask() {
		            @Override
		            public void run() {
		                game.start();
		            }
		        }, 5000 );
	}
	
	
	private static OfflineGame initOffline() {
		GameCreator<?, ?> gameCreator = GameCreatorFactory.getGameCreatorFor(new GameCreationEvent("map1", 4, false));
		gameCreator.create();
		OfflineGame game = (OfflineGame) gameCreator.getGame();
		return game;
	}
	
	
	private static OnlineGame initOnline() throws RemoteException {
		int id = ClientIdProvider.getClientId();
		LobbyProviderAgent lobbyProviderAgent = ServerConnectionProvider.getLobbyProviderAgent();
		ServersideGameCreationEvent serversideGameCreationEvent = new ServersideGameCreationEvent("map1", 2, id);
		String lobbyName = lobbyProviderAgent.join(serversideGameCreationEvent);
		LobbyAgent lobbyAgent = (LobbyAgent) ServerConnectionProvider.lookup(lobbyName);
		
		boolean ready = lobbyAgent.hasStarted();
		while (!ready) {
			ready = lobbyAgent.hasStarted();
		}
		
		String gameName = lobbyAgent.getGameAgent(id);
		GameAgent gameAgent = (GameAgent) ServerConnectionProvider.lookup(gameName);
		OnlineGameCreationEvent onlineGameCreationEvent = gameAgent.getGame(id);
		GameCreator<?, ?> gameCreator = GameCreatorFactory.getGameCreatorFor(onlineGameCreationEvent);
		gameCreator.create();
		OnlineGame game = (OnlineGame) gameCreator.getGame();
		game.setGameAgent(gameAgent);
		return game;
	}
	
}
