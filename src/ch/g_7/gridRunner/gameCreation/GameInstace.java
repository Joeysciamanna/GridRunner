package ch.g_7.gridRunner.gameCreation;

import java.awt.event.KeyListener;
import java.util.ArrayList;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.playerStatus.PlayerStatusWorker;

public class GameInstace {

	private FieldGrid grid;
	private ArrayList<Controller> controllers;
	private ArrayList<PlayerStatusWorker> workers;
	private boolean activated;
	
	public GameInstace() {
		controllers = new ArrayList<>();
		workers = new ArrayList<>();
	}
	
	
	public void setGrid(FieldGrid grid) {
		this.grid = grid;
	}
	
	public void addController(Controller controller) {
		controllers.add(controller);
	}
		
	public void addPlayerStatusWorker(PlayerStatusWorker worker) {
		workers.add(worker);
	}
		
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		int i = 1;
		Player player = getPlayer(i);
		while(player!=null) {
			players.add(player);
			player = getPlayer(++i);
		}
		return players;
	}
	
	public Player getPlayer(int n) {
		return (Player) grid.getFieldWhere(new FieldCode("PLAYER",String.valueOf(n)));
	}
	
	public FieldGrid getGrid() {
		return grid;
	}

	public Controller getController(int index) {
		return controllers.get(index);
	}


	public void activate() {
		if(!activated) {
			for (PlayerStatusWorker worker : workers) {
				Thread t = new Thread(worker);
				t.start();
			}
			for (Controller controller : controllers) {
				Thread t = new Thread(controller);
				t.start();
			}
			activated = true;
		}
	}


	public ArrayList<Controller> getControllers() {
		return controllers;
	}
	
}
