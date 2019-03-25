package ch.g_7.gridRunner.connection;

import java.rmi.RemoteException;

public class ClientIdProvider {

	private static int clientId = 0;
	
	public static int getClientId() {
		if(clientId==0) {
			try {
				clientId = ServerConnectionProvider.getClientIdAgent().getNewId();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return clientId;
	}
}
