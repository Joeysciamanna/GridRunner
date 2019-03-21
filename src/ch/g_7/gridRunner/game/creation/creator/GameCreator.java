package ch.g_7.gridRunner.game.creation.creator;

import java.io.File;
import java.io.IOException;

import ch.g_7.gridEngine.stream.MapReader;
import ch.g_7.gridRunner.game.Game;
import ch.g_7.gridRunner.game.GameFitsException;
import ch.g_7.gridRunner.game.MapMetaData;
import ch.g_7.gridRunner.game.creation.event.GameCreationEvent;

public abstract class GameCreator<T extends Game,V extends GameCreationEvent> {

	protected V event;
	
	public GameCreator(V event) {
		this.event = event;
	}


	public void create() {
		MapReader<MapMetaData> mapReader = new MapReader<MapMetaData>(new MapMetaData());
		try {
			mapReader.read(new File("resources/maps/"+event.getMap()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(mapReader.getMeta().fits(event)) {
			throw new GameFitsException();
		}
		getGame().setGrid(mapReader.getGrid());
		getGame().setMetaData(mapReader.getMeta());
		init();
	}
	
	protected abstract void init();
	public abstract T getGame();
}
