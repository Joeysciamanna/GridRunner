package ch.g_7.gridRunner.gameCreation;

import java.io.Serializable;

public class GameCreationEvent implements Serializable{

	private static final long serialVersionUID = -932920361483957465L;
	
	private boolean local;
	private String mapName;
	
	public GameCreationEvent() {}
	
	public GameCreationEvent(boolean local,String mapName) {
		this.local = local;
		this.mapName = mapName;
	}
	
	public boolean isLocal() {
		return local;
	}
	
	public String getMapName() {
		return mapName;
	}
}
