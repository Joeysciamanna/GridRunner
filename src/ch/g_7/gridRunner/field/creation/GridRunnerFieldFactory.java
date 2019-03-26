package ch.g_7.gridRunner.field.creation;

import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.DefaultFieldFactory;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.field.Grass;
import ch.g_7.gridRunner.field.Rock;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Player;
import ch.g_7.gridRunner.field.spawn.Spawn;

public class GridRunnerFieldFactory extends DefaultFieldFactory{

	@Override
	public Field<?> getField(FieldCode code) {
		switch (code.getFieldType()) {
		case "SPAWN":
			return new Spawn(code.getAdditionalArguments());
		case "GRASS":
			return new Grass();
		case "ROCK":
			return new Rock();
		default:
			return null;
		}
	}
}
