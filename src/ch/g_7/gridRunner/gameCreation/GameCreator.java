package ch.g_7.gridRunner.gameCreation;

public abstract class GameCreator {

	protected GameCreationEvent event;
	protected GameInstace game;
	
	public GameCreator(GameCreationEvent event) {
		this.event = event;
	}
	
	public abstract void create();
	
	public GameInstace getGame() {
		return game;
	}
}
