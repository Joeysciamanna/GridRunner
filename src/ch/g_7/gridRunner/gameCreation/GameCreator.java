package ch.g_7.gridRunner.gameCreation;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.PlayerKeyListner.KeyController;
import ch.g_7.gridRunner.helper.KeySet;
import ch.g_7.gridRunner.server.ServerInterface;

public class GameCreator {

	public static GameInstace getNewGame(GameCreationEvent event) {
		GameInstace game = new GameInstace();
		if (event.isLocal()) {
			game.setGrid(new MapReader(new File("resources/maps/" + event.getMapName() +".xml")).read());
			game.addController(new KeyController(game.getPlayer(1), KeySet.WASD));
			game.addController(new KeyController(game.getPlayer(2), KeySet.ARROW));
		} else {
			game.setGrid(new MapReader(new File("resources/maps/" + event.getMapName() +".xml")).read());
			game.addController(new KeyController(game.getPlayer(1), KeySet.WASD));
			game.addController(new KeyController(game.getPlayer(2), KeySet.ARROW));
			
			System.out.println("HIII");
			try {
				ServerInterface look_up = (ServerInterface) Naming.lookup("rmi://localhost:1109/server");
				
				while (look_up.helloTo("TEST") == null) {}
				String test = look_up.helloTo("TEST");
				System.out.println(test);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return game;
	}
}
