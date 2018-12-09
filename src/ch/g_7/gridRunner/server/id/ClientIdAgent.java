package ch.g_7.gridRunner.server.id;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.id.ClientId;

public interface ClientIdAgent extends Remote, Serializable{

	public ClientId newClientId() throws RemoteException;
}
