package ch.g_7.gridRunner.fields.building;

import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.DefaultFieldFactory;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.fields.Grass;
import ch.g_7.gridRunner.fields.Player;

public class GridRunnerFieldFactory extends DefaultFieldFactory{

	@Override
	public Field<?> getField(FieldCode code) {
		
		switch (code.getFieldType()) {
		case "PLAYER":
			return new Player();
		case "GRASS":
			return new Grass();
		default:
			return super.getField(code);
		}
	}
}
