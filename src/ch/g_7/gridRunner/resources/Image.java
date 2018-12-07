package ch.g_7.gridRunner.resources;

public enum Image {
	PLAYER1(""),
	PLAYER2(""),
	GRASS("resources/fields/GRASS.png"),
	LAVA("");
	
	
	private String path;
	
	private Image(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
