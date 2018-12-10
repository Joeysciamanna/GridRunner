package ch.g_7.gridRunner.server.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.server.gameCreation.OnlineGameInstance;

public class GameAgentImpl extends UnicastRemoteObject implements GameAgent {

	private static final long serialVersionUID = 1L;

	private ClientId client1;
	private boolean shared1 = false;
	private ClientId client2;
	private boolean shared2 = false;
	
	public GameAgentImpl() throws RemoteException {
		super();
	}
	
	@Override
	public synchronized OnlineGameInstance joinGameSession(ClientId client) throws RemoteException {
		if(client1 == null && client2 == null) {
			System.err.println("Client 1: " + client.getId() + " registered");
			client1 = client;
		}else if(client2 == null && !client1.equals(client)) {
			System.err.println("Client 2: " + client.getId() + " registered");
			client2 = client;
			
		}else if(client1 != null && client2 != null) {
			if(client1.equals(client)) {
				System.err.println("Sharing with Client 1: " + client.getId());
				shared1 = true;
			}else if(client2.equals(client)) {
				System.err.println("Sharing with Client 2: " + client.getId());
				shared2 = true;
			}
			return startGameSession();
		}
		return null;
	}

	private synchronized OnlineGameInstance startGameSession() {
		OnlineGameInstance gameInstance = new OnlineGameInstance("map1", client1, client2);
		System.err.println("Returning OnlineGameInstace for: "+client1.getId()+" & "+client2.getId());
		clearSession();
		return gameInstance;
	}
	
	private synchronized void clearSession() {
		if(shared1 && shared2) {
			System.err.println("Clearing Session\n");
			client1 = null;
			client2 = null;
			shared1 = false;
			shared2 = false;
		}
	}
}
