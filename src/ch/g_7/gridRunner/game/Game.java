package ch.g_7.gridRunner.game;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.base.Startable;
import ch.g_7.gridRunner.field.controlable.Player;
import ch.g_7.gridRunner.field.spawn.Spawn;

public abstract class Game implements Startable{

	private FieldGrid grid;
	private MapMetaData metaData;
	private ArrayList<Startable> startables;
	
	public Game() {
		startables = new ArrayList<>();
	}
	
	public Spawn getSpawn(int i) {
		ArrayList<Field<?>> spawns = grid.getFieldsWhere(new FieldCode("SPAWN",String.valueOf(i)));
		return spawns.size() > 0 ? (Spawn) spawns.get(0) : null;
	}
	
	public ArrayList<Spawn> getSpawns() {
		ArrayList<Field<?>> fields = grid.getFieldsWhere(new FieldCode("SPAWN"));
		ArrayList<Spawn> spawns = new ArrayList<>();
		for (Field<?> field : fields) {
			spawns.add((Spawn) field);
		}
		return spawns;
	}
	
	public void addPlayer(Player player, Position position) {
		grid.addField(player, position);
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
