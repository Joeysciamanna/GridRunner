package ch.g_7.gridRunner.identification;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

import ch.g_7.gridRunner.connection.ServerConnectionEstablisher;
import ch.g_7.gridRunner.server.id.ClientIdAgent;

public class ClientIdProvider {

	private static long clientId = 0;
	
	private static void requestId() {
		long id = 0;
		try {
			ClientIdAgent clientIdAgent = ServerConnectionEstablisher.getClientIdAgent();
			id = clientIdAgent.newClientId();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		clientId = id;
	}
	
	public static long getClientId() {
		if(clientId == 0) {
			requestId();
		}
		return clientId;
	}
}
