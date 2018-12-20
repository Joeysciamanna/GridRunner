package ch.g_7.gridRunner.gameCreation;

import java.io.File;

import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.helper.KeySet;

public class LocalGameCreator extends GameCreator{
	
	public LocalGameCreator(GameCreationEvent event) {
		super(event);
	}


	@Override
	public void create() {
		GameInstace game = new GameInstace();
		game.setGrid(new MapReader(new File("resources/maps/" + event.getMapName() + ".xml")).read());
		game.addController(new Controller(game.getPlayer(1), KeySet.WASD));
		game.addController(new Controller(game.getPlayer(2), KeySet.ARROW));
		this.game = game;
	}
}
