package ch.g_7.gridRunner.server.id;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

import ch.g_7.gridRunner.id.ClientId;

public class ClientIdAgentImpl extends UnicastRemoteObject implements ClientIdAgent{

	private static final long serialVersionUID = 1L;
	
	ArrayList<Integer> ids = new ArrayList<>();
	
	public ClientIdAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public ClientId newClientId() throws RemoteException {
		int id = new Random().nextInt();
		while(ids.contains(id)) {
			id = new Random().nextInt();
		}
		ids.add(id);
		System.err.println("New Client Id: " + id);
		return new ClientId(id);
	}

}
