package ch.g_7.gridRunner.id;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

import ch.g_7.gridRunner.connection.ServerConnectionEstablisher;
import ch.g_7.gridRunner.server.id.ClientIdAgent;

public class LocalClientId {

	private static ClientId clientId;
	
	private static void requestId() {
		ClientId id = null;
		try {
			ClientIdAgent clientIdAgent = ServerConnectionEstablisher.getClientIdAgent();
			id = clientIdAgent.newClientId();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		if(id == null) {
			clientId = new ClientId(new Random().nextInt());
		}else {
			clientId = id;
		}
	}
	
	public static ClientId getClientId() {
		if(clientId == null) {
			requestId();
		}
		return clientId;
	}
}
