package ch.g_7.gridRunner.server;

import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.field.creation.GridRunnerFieldFactory;
import ch.g_7.gridRunner.server.player.ServersidePlayer;

public class ServersideFieldFactory extends GridRunnerFieldFactory{

	@Override
	public Field<?> getField(FieldCode code) {
		switch (code.getFieldType()) {
		case "PLAYER":
			return new ServersidePlayer(Integer.parseInt(code.getAdditionalArguments()[0]));
		default:
			return super.getField(code);
		}
	}
}
