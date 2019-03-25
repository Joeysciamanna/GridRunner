package ch.g_7.gridRunner.controller.bot.aim;

import java.util.ArrayList;

import ch.g_7.gridEngine.core.FieldGrid;
import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.field.controlable.Player;

public class NearestAimProvider implements AimProvider{

	private Player start;
	private FieldGrid grid;
	
	public NearestAimProvider(Player start, FieldGrid grid) {
		this.start = start;
		this.grid = grid;
	}
	
	@Override
	public Player getAim() {
		ArrayList<Field<?>> aims = grid.getNearestFieldsWhere(new FieldCode("PLAYER"),start.getPosition());
		for (Field<?> field : aims) {
			if(!((Player)field).isBot()) {
				return (Player) field;
			}
		}
		return (Player) aims.get(0);
	}

}
