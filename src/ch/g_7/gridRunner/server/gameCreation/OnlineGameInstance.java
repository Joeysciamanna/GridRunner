package ch.g_7.gridRunner.server.gameCreation;

import java.io.Serializable;

import ch.g_7.gridRunner.identification.ClientId;

public class OnlineGameInstance implements Serializable{

	private static final long serialVersionUID = 1L;

	private String map;
	private ClientId client1;
	private ClientId client2;
	
	public OnlineGameInstance(String map,ClientId client1,ClientId client2) {
		this.map = map;
		this.client1 = client1;
		this.client2 = client2;
	}
	
	public String getMap() {
		return map;
	}
	
	public int getPlayerNr(ClientId id) {
		if(client1.equals(id)) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public int getVillanNr(ClientId id) {
		if(client1.equals(id)) {
			return 2;
		}else {
			return 1;
		}
	}

	
	public ClientId geVillanId(ClientId id) {
		if(client1.equals(id)) {
			return client2;
		}else {
			return client1;
		}
	}
	
}
