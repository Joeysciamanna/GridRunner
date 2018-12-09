package ch.g_7.gridRunner.gameCreation;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.PlayerKeyListner.KeyController;
import ch.g_7.gridRunner.PlayerKeyListner.RemoteController;
import ch.g_7.gridRunner.fields.Player;

public class GameInstace {

	private FieldGrid grid;
	private KeyController controller1;
	private KeyController controller2;
	private RemoteController remoteController1;
	private RemoteController remoteController2;
	
	public void setGrid(FieldGrid grid) {
		this.grid = grid;
	}
	
	public void addController(KeyController controller) {
		if(controller1 == null) {
			controller1 = controller;
		}else {
			controller2 = controller;
		}
	}
		
	public void addController(RemoteController controller) {
		if(remoteController1 == null) {
			remoteController1 = controller;
		}else {
			remoteController2 = controller;
		}
	}
	
	public Player getPlayer(int n) {
		return (Player) grid.getFieldWhere(new FieldCode("PLAYER",String.valueOf(n)));
	}
	
	public FieldGrid getGrid() {
		return grid;
	}

	public KeyController getController1() {
		return controller1;
	}
	public KeyController getController2() {
		return controller2;
	}
	
	public void activateControllers() {
		if (controller1 != null) {
			Thread t = new Thread(controller1);
			t.start();
		}
		if (controller2 != null) {
			Thread t = new Thread(controller2);
			t.start();
		}
		if (remoteController1 != null) {
			Thread t = new Thread(remoteController1);
			t.start();
		}
		if (remoteController2 != null) {
			Thread t = new Thread(remoteController2);
			t.start();
		}
	}
	
}
