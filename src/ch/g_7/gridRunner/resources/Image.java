package ch.g_7.gridRunner.resources;

public enum Image {
	PLAYER1_UP("resources/players/PLAYER1-UP.png"),
	PLAYER1_LEFT("resources/players/PLAYER1-LEFT.png"),
	PLAYER1_DOWN("resources/players/PLAYER1-DOWN.png"),
	PLAYER1_RIGHT("resources/players/PLAYER1-RIGHT.png"),
	PLAYER2_UP("resources/players/PLAYER2-UP.png"),
	PLAYER2_LEFT("resources/players/PLAYER2-LEFT.png"),
	PLAYER2_DOWN("resources/players/PLAYER2-DOWN.png"),
	PLAYER2_RIGHT("resources/players/PLAYER2-RIGHT.png"),
	
	GRASS("resources/fields/GRASS.png"),
	ROCK("resources/fields/ROCK.png"),
	
	MAIN_VIEW("resources/images/MAIN-VIEW.png");
	
	
	private String path;
	
	private Image(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
