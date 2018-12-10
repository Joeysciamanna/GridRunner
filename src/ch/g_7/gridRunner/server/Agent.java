package ch.g_7.gridRunner.server;

public enum Agent {
	GAME("gameAgent"),
	PLAYER_STATUS("playerStatusAgent"),
	CLIENT_ID("clientIdAgent");
	
	private String name;
	
	private Agent(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
