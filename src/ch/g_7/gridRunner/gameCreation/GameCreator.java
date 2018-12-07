package ch.g_7.gridRunner.gameCreation;

import java.io.File;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.PlayerKeyListner.KeyController;
import ch.g_7.gridRunner.PlayerKeyListner.PlayerController;

public class GameCreator {

	public static GameInstace getNewGame(GameCreationEvent event) {
		GameInstace game = new GameInstace();
		if (event.isLocal()) {
			game.setGrid(new MapReader(new File("resources/map/" + event.getMapName() +".xml")).read().getGrid());
			game.setController1(new KeyController(player, keySet));
		}
	}
}
