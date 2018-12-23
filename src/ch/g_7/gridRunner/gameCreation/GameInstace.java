package ch.g_7.gridRunner.gameCreation;

import java.util.ArrayList;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.controller.Controller;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.gui.Window;
import ch.g_7.gridRunner.playerStatus.PlayerStatusWorker;

public class GameInstace {

	private FieldGrid grid;
	private Controller controller1;
	private Controller controller2;
	private PlayerStatusWorker worker1;
	private PlayerStatusWorker worker2;
	private boolean activated;
	
	public void setGrid(FieldGrid grid) {
		this.grid = grid;
	}
	
	public void addController(Controller controller) {
		if(controller1 == null) {
			controller1 = controller;
		}else {
			controller2 = controller;
		}
	}
		
	public void addPlayerStatusWorker(PlayerStatusWorker worker) {
		if(worker1 == null) {
			worker1 = worker;
		}else {
			worker2 = worker;
		}
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
	
	public Player getPlayedr(int n) {
		return (Player) grid.getFieldWhere(new FieldCode("PLAYER",String.valueOf(n)));
	}
	
	public FieldGrid getGrid() {
		return grid;
	}

	public Controller getController1() {
		return controller1;
	}
	
	public Controller getController2() {
		return controller2;
	}

	public void activate() {
		if(!activated) {
			if (controller1 != null) {
				Window.addController(controller1);
				Thread t = new Thread(controller1);
				t.start();
			}
			if (controller2 != null) {
				Window.addController(controller2);
				Thread t = new Thread(controller2);
				t.start();
			}
			if (worker1 != null) {
				Thread t = new Thread(worker1);
				t.start();
			}
			if (worker2 != null) {
				Thread t = new Thread(worker2);
				t.start();
			}
			activated = true;
		}
	}
	
}
