package ch.g_7.gridRunner.server.clientId;

import java.rmi.RemoteException;

import ch.g_7.gridRunner.server.IDProvider;
import ch.g_7.gridRunner.server.agent.Agent;

public class ClientIdAgentImpl extends Agent implements ClientIdAgent{

	protected ClientIdAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public int getNewId() throws RemoteException {
		return IDProvider.getId(getClass().getName());
	}

}
