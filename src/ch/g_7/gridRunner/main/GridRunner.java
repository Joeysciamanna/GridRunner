package ch.g_7.gridRunner.main;

import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javax.jws.Oneway;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridRunner.connection.ServerConnectionProvider;
import ch.g_7.gridRunner.fieldCreation.GridRunnerFieldFactory;
import ch.g_7.gridRunner.game.Game;
import ch.g_7.gridRunner.game.OfflineGame;
import ch.g_7.gridRunner.game.creation.GameCreatorFactory;
import ch.g_7.gridRunner.game.creation.creator.GameCreator;
import ch.g_7.gridRunner.game.creation.creator.OfflineGameCreator;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;

public class GridRunner {
	
	public static void main(String[] args) {
//		try {
//			ServerConnectionProvider.getPlayerStatusAgent().move();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		FieldCreationRegister.setDefaultFactory(new GridRunnerFieldFactory());
		
		GameCreator<OfflineGame, GameCreationEvent> gameCreator = GameCreatorFactory.getGameCreatorFor(new GameCreationEvent("map1", 4, false));
		gameCreator.create();
		OfflineGame game = gameCreator.getGame();
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
		
		
	}
	
}
