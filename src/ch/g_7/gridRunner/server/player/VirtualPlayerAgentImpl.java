package ch.g_7.gridRunner.server.player;

import java.rmi.RemoteException;

import ch.g_7.gridEngine.base.Dimension;
import ch.g_7.gridEngine.base.Position;
import ch.g_7.gridRunner.fields.controlable.Player;
import ch.g_7.gridRunner.server.IDProvider;
import ch.g_7.gridRunner.server.agent.Agent;

public class VirtualPlayerAgentImpl extends Agent implements VirtualPlayerAgent{

	private static final long serialVersionUID = 7340528275258635988L;
	
	private int id;
	private VirtualPlayer virtualPlayer;
	
	public VirtualPlayerAgentImpl(VirtualPlayer virtualPlayer) throws RemoteException {
		id = IDProvider.getId(getClass().getName());
		this.virtualPlayer = virtualPlayer;
	}

	public int getPlayerNr() {
		return virtualPlayer.getPlayerNr();
	}
	
	@Override
	public String getName() {
		return getClass().getName() + "-" + id;
	}

	@Override
	public boolean move(Dimension d) throws RemoteException {
		return virtualPlayer.move(d);
	}

	@Override
	public boolean isBot() throws RemoteException {
		return virtualPlayer.isBot();
	}

	@Override
	public void setBot(boolean b) throws RemoteException {
		virtualPlayer.setBot(b);
	}

	@Override
	public Position getPosition() throws RemoteException {
		return virtualPlayer.getPosition();
	}


}
