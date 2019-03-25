package ch.g_7.gridRunner.server.agent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch.g_7.logger.main.Logger;

public abstract class Agent extends UnicastRemoteObject{

	private static final long serialVersionUID = -755371809171872842L;
	protected static final Logger LOGGER = Logger.getInstance();
	
	protected Agent() throws RemoteException {
		super();
	}

	public abstract String getName();

}
