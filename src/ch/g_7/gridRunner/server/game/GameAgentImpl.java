package ch.g_7.gridRunner.server.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch.g_7.gridRunner.gameCreation.OnlineGameData;
import ch.g_7.gridRunner.identification.ClientId;

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
	public synchronized OnlineGameData joinGameSession(ClientId client) throws RemoteException {
		if(client1 == null && client2 == null) {
			System.err.println("Client 1 of 2 (" + client.getId() + ") has registered");
			client1 = client;
		}else if(client2 == null && !client1.equals(client)) {
			System.err.println("Client 2 of 2 (" + client.getId() + ") has registered");
			client2 = client;
			
		}else if(client1 != null && client2 != null) {
			if(client1.equals(client)) {
				System.err.println("Sharing GameInstance (NR) with Client 1 (" + client.getId() + ")");
				shared1 = true;
			}else if(client2.equals(client)) {
				System.err.println("Sharing GameInstance (NR) with Client 2 (" + client.getId() + ")");
				shared2 = true;
			}
			return getNewOnlineGame();
		}
		return null;
	}

	private synchronized OnlineGameData getNewOnlineGame() {
		OnlineGameData gameInstance = new OnlineGameData("map1", client1, client2);
		clearSession();
		return gameInstance;
	}
	
	private synchronized void clearSession() {
		if(shared1 && shared2) {
			System.err.println("Clearing Session for (NR)");
			client1 = null;
			client2 = null;
			shared1 = false;
			shared2 = false;
		}
	}
}
