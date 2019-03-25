package ch.g_7.gridRunner.game;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.field.controlable.Player;

public abstract class Game implements Startable{

	private FieldGrid grid;
	private MapMetaData metaData;
	private ArrayList<Startable> startables;
	
	
	public Game() {
		startables = new ArrayList<>();
	}
	
	public Player getPlayer(int i) {
		return (Player) grid.getFieldsWhere(new FieldCode("PLAYER",String.valueOf(i))).get(0);
	}
	
	@Override
	public void start() {
		for (Startable startable : startables) {
			startable.start();
		}
	}

	@Override
	public void stop() {
		for (Startable startable : startables) {
			startable.stop();
		}
	}
	
	public FieldGrid getGrid() {
		return grid;
	}
	
	public void setGrid(FieldGrid grid) {
		this.grid = grid;
	}
	
	public MapMetaData getMetaData() {
		return metaData;
	}
	
	public void setMetaData(MapMetaData metaData) {
		this.metaData = metaData;
	}
	
	public void addStartable(Startable startable) {
		startables.add(startable);
	}

}
