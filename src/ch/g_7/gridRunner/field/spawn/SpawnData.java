package ch.g_7.gridRunner.field.spawn;

import ch.g_7.gridEngine.base.Position;

public class SpawnData {

	private int nr;
	private Position position;
	private boolean bot;
	private boolean player;
	private String botController;

	public SpawnData(Position position, String... codeArgs) {
		this.position = position;
		this.bot = Boolean.valueOf(codeArgs[1]);
		this.player = Boolean.valueOf(codeArgs[2]);
		this.botController = codeArgs[3];
	}
	
	public int getNr() {
		return nr;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean isBot() {
		return bot;
	}
	
	public boolean isPlayer() {
		return player;
	}
	
	public String getBotController() {
		return botController;
	}
}
