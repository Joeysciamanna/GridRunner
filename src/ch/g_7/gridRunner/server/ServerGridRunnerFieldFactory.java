package ch.g_7.gridRunner.server;

import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.fieldCreation.GridRunnerFieldFactory;
import ch.g_7.gridRunner.fields.Grass;
import ch.g_7.gridRunner.fields.Rock;
import ch.g_7.gridRunner.fields.controlable.Player;
import ch.g_7.gridRunner.server.player.VirtualPlayer;

public class ServerGridRunnerFieldFactory extends GridRunnerFieldFactory{

	@Override
	public Field<?> getField(FieldCode code) {
		switch (code.getFieldType()) {
		case "PLAYER":
			return new VirtualPlayer(Integer.parseInt(code.getAdditionalArguments()[0]));
		default:
			return super.getField(code);
		}
	}
}
