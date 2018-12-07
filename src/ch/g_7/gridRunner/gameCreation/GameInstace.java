package ch.g_7.gridRunner.gameCreation;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.PlayerKeyListner.PlayerController;
import ch.g_7.gridRunner.fields.Player;

public class GameInstace {

	private FieldGrid grid;
	private PlayerController controller1;
	private PlayerController controller2;
	
	public void setGrid(FieldGrid grid) {
		this.grid = grid;
	}
	
	public void setController1(PlayerController controller1) {
		this.controller1 = controller1;
	}
	
	public void setController2(PlayerController controller2) {
		this.controller2 = controller2;
	}
	
	public Player getPlayer(int n) {
		return (Player) grid.getFieldWhere(new FieldCode("PLAYER",String.valueOf(n)));
	}
	
	public FieldGrid getGrid() {
		return grid;
	}
}
