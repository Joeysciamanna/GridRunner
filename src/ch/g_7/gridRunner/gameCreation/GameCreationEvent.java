package ch.g_7.gridRunner.gameCreation;

import java.io.Serializable;

public class GameCreationEvent implements Serializable{

	private static final long serialVersionUID = -932920361483957465L;
	
	private boolean local;
	private String mapName;
	private int playerCount;
	private long creatorsId;
	
	public GameCreationEvent(boolean local,String mapName,int playerCount,long creatorsId) {
		this.local = local;
		this.mapName = mapName;
		this.playerCount = playerCount;
		this.creatorsId = creatorsId;
	}
	
	public boolean isLocal() {
		return local;
	}

	public String getMapName() {
		return mapName;
	}

	public int getPlayerCount() {
		return playerCount;
	}
	
	public long getCreatorsId() {
		return creatorsId;
	}

}
