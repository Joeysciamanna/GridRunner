package ch.g_7.gridRunner.server.clientId;

import java.rmi.RemoteException;

public interface ClientIdAgent {

	public int getNewId() throws RemoteException;
}
