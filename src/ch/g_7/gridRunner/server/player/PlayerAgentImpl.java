package ch.g_7.gridRunner.server.player;

import java.rmi.RemoteException;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridRunner.server.IDProvider;
import ch.g_7.gridRunner.server.agent.Agent;

public class PlayerAgentImpl extends Agent implements PlayerAgent{

	private static final long serialVersionUID = 7340528275258635988L;
	
	private int id;
	private ServersidePlayer player;
	
	public PlayerAgentImpl(ServersidePlayer player) throws RemoteException {
		id = IDProvider.getId(getClass().getName());
		this.player = player;
	}

	@Override
	public String getName() {
		return getClass().getSimpleName() + "-" + id;
	}
	
	@Override
	public synchronized int getPlayerNr() throws RemoteException {
		return player.getPlayerNr();
	}
	
	@Override
	public synchronized boolean move(Dimension d) throws RemoteException {
		return player.move(d);
	}

	@Override
	public synchronized boolean isBot() throws RemoteException {
		return player.isBot();
	}

	@Override
	public synchronized void setBot(boolean b) throws RemoteException {
		player.setBot(b);
	}

	@Override
	public synchronized Position getPosition() throws RemoteException {
		return player.getPosition();
	}

}
