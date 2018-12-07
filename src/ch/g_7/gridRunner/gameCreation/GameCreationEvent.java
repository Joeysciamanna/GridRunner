package ch.g_7.gridRunner.gameCreation;

public class GameCreationEvent {

	private boolean local;
	private String mapName;
	
	public GameCreationEvent() {}
	
	public GameCreationEvent(boolean local,String mapName) {
		
	}
	
	public boolean isLocal() {
		return local;
	}
	
	public String getMapName() {
		return mapName;
	}
}
