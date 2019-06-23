package ch.g_7.gridRunner.game.creation.event;

public class ServersideGameCreationEvent extends GameCreationEvent{

	private int clientId;
	
	public ServersideGameCreationEvent(String map, int playerCount, int cientId) {
		super(map, playerCount, true, true);
		this.clientId = cientId;
	}

	public int getClientId() {
		return clientId;
	}

}
