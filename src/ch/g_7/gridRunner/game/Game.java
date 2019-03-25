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

public abstract class Game implements Startable{

	private FieldGrid grid;
	private MapMetaData metaData;
	private ArrayList<Startable> startables;
	private ArrayList<Integer> usedPlayers;
	
	public Game() {
		startables = new ArrayList<>();
		usedPlayers = new ArrayList<>();
	}
	
	public Player getPlayer(int i) {
		ArrayList<Field<?>> players = grid.getFieldsWhere(new FieldCode("PLAYER",String.valueOf(i)));
		return players.size() > 0 ? (Player) players.get(0) : null;
	}
	
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		int i = 1;
		Player player = getPlayer(i);
		while (player!=null) {
			players.add(player);
			player = getPlayer(++i);
		}
		return players;
	}
	
	public void setPlayerAsUsed(int i) {
		usedPlayers.add(i);
	}
	
	public void removeUnUsedPlayers() {
		for (Player p : getPlayers()) {
			if(!usedPlayers.contains(p.getPlayerNr())) {
				p.removeSelf();
			}
		}
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
