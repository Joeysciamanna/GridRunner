package ch.g_7.gridRunner.server.clientId;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.server.IDProvider;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.agent.Agents;
import ch.g_7.logger.main.Level;

public class ClientIdProviderAgentImpl extends Agent implements ClientIdProviderAgent{
	

	private static final long serialVersionUID = 1404555169769149058L;

	public ClientIdProviderAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public String getName() {
		return Agents.CLIENT_ID.toString();
	}

	@Override
	public synchronized int getNewId() throws RemoteException {
		int id = IDProvider.getId(getClass().getName());
		LOGGER.log(Level.INFO, "New client id " + id);
		return id;
	}

}
