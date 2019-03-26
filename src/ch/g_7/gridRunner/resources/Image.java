package ch.g_7.gridRunner.resources;

import java.io.Serializable;

public enum Image implements Serializable{
	
	PLAYER1_UP("resources/fields/players/PLAYER1-UP.png"),
	PLAYER1_LEFT("resources/fields/players/PLAYER1-LEFT.png"),
	PLAYER1_DOWN("resources/fields/players/PLAYER1-DOWN.png"),
	PLAYER1_RIGHT("resources/fields/players/PLAYER1-RIGHT.png"),
	PLAYER2_UP("resources/fields/players/PLAYER2-UP.png"),
	PLAYER2_LEFT("resources/fields/players/PLAYER2-LEFT.png"),
	PLAYER2_DOWN("resources/fields/players/PLAYER2-DOWN.png"),
	PLAYER2_RIGHT("resources/fields/players/PLAYER2-RIGHT.png"),
	
	GRASS("resources/fields/GRASS.png"),
	ROCK("resources/fields/ROCK.png"),
	
	VOID("");
	
	
	private String path;
	
	private Image(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
