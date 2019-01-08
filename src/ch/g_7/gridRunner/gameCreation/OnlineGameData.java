package ch.g_7.gridRunner.gameCreation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import ch.g_7.gridRunner.identification.ClientId;

public class OnlineGameData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String map;
	private ArrayList<ClientId> clients;
	
	public OnlineGameData(String map,ClientId...clientIds) {
		clients = new ArrayList<>();
		clients.addAll(Arrays.asList(clientIds));
		System.out.println("Playerrs i Online Instance: " + clients.get(0).getId() + "-" + clients.get(1).getId());
		this.map = map;
	}
	
	public String getMap() {
		return map;
	}
	
	public int getPlayerNr(ClientId id) {
		return clients.indexOf(id)+1;
	}
	
	public ClientId getClientId(int playerNr) {
		return clients.get(playerNr-1);
	}
	
}
