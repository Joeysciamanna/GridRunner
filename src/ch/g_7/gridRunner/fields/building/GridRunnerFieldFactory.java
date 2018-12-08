package ch.g_7.gridRunner.fields.building;

import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.DefaultFieldFactory;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.fields.Grass;
import ch.g_7.gridRunner.fields.Player;
import ch.g_7.gridRunner.fields.Rock;
import ch.g_7.gridRunner.id.ClientId;

public class GridRunnerFieldFactory extends DefaultFieldFactory{

	@Override
	public Field<?> getField(FieldCode code) {
		
		switch (code.getFieldType()) {
		case "PLAYER":
			return new Player(new ClientId(Integer.parseInt(code.getAdditionalArguments()[0])));
		case "GRASS":
			return new Grass();
		case "ROCK":
			return new Rock();
		default:
			return null;
		}
	}
}
