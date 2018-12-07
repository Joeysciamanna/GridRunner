package ch.g_7.gridRunner.gameCreation;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.core.FieldStack;
import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.helper.Lambda;
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
	
	public Player getPlayer1() {
		return (Player) grid.forEach(new Lambda<Field<?>, FieldStack>() {
			@Override
			public Field<?> apply(FieldStack o) {
				
			}
		}).getNotNull();
	}
	
	
}
