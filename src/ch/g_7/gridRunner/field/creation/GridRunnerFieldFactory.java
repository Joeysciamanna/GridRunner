package ch.g_7.gridRunner.field.creation;

import ch.g_7.gridEngine.field.Field;
import ch.g_7.gridEngine.field.building.DefaultFieldFactory;
import ch.g_7.gridEngine.field.building.FieldCode;
import ch.g_7.gridRunner.field.Grass;
import ch.g_7.gridRunner.field.Rock;
import ch.g_7.gridRunner.field.controlable.Bot;
import ch.g_7.gridRunner.field.controlable.Player;

public class GridRunnerFieldFactory extends DefaultFieldFactory{

	@Override
	public Field<?> getField(FieldCode code) {
		switch (code.getFieldType()) {
		case "PLAYER":
			Player player = null;
			if(code.containsArg("BOT")) {
				player = new Bot(Integer.parseInt(code.getAdditionalArguments()[0]), code.getAdditionalArguments()[2]);
				player.setBot(true);
			}else {
				player = new Player(Integer.parseInt(code.getAdditionalArguments()[0]));
				player.setBot(false);
			}
			return player;
		case "GRASS":
			return new Grass();
		case "ROCK":
			return new Rock();
		default:
			return null;
		}
	}
}
