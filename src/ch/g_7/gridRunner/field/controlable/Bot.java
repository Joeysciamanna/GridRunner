package ch.g_7.gridRunner.field.controlable;

import ch.g_7.gridEngine.field.building.FieldCode;

public class Bot extends Player{

	private String botControllerName;
	
	public Bot(int player,String botControllerName) {
		super(player);
		setBot(true);
	}

	@Override
	public FieldCode getCode() {
		return new FieldCode("PLAYER",String.valueOf(getPlayerNr()),botControllerName);
	}
	
	public String getBotControllerName() {
		return botControllerName;
	}
}
