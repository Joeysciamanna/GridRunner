package ch.g_7.gridRunner.gameCreation;

import java.io.File;
import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.PlayerKeyListner.KeyController;
import ch.g_7.gridRunner.helper.KeySet;

public class GameCreator {

	public static GameInstace getNewGame(GameCreationEvent event) {
		GameInstace game = new GameInstace();
		if (event.isLocal()) {
			game.setGrid(new MapReader(new File("resources/maps/" + event.getMapName() +".xml")).read());
			game.setController1(new KeyController(game.getPlayer(1), KeySet.WASD));
			game.setController2(new KeyController(game.getPlayer(2), KeySet.ARROW));
		} else {
			System.out.println("HIII");
		}
		return game;
	}
}
