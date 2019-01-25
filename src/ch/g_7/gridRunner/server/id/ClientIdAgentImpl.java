package ch.g_7.gridRunner.server.id;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class ClientIdAgentImpl extends UnicastRemoteObject implements ClientIdAgent{

	private static final long serialVersionUID = 1L;
	
	ArrayList<Long> ids = new ArrayList<>();
	
	public ClientIdAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public long newClientId() throws RemoteException {
		long id = new Random().nextLong();
		while(ids.contains(id)) {
			id = new Random().nextLong();
		}
		ids.add(id);
		System.err.println("New Client Id: " + id);
		return id;
	}

}
