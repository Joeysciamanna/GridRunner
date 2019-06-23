package ch.g_7.gridRunner.server.clientId;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientIdProviderAgent extends Remote, Serializable{

	public int getNewId() throws RemoteException;
}
