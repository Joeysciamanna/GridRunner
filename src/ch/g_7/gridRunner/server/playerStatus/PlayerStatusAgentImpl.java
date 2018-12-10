package ch.g_7.gridRunner.server.playerStatus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import ch.g_7.gridRunner.id.ClientId;
import ch.g_7.gridRunner.playerStatus.PlayerStatus;

public class PlayerStatusAgentImpl extends UnicastRemoteObject implements PlayerStatusAgent{

	private static final long serialVersionUID = 2027480092072051883L;
	Map<Integer, PlayerStatus> playerStatuses = new HashMap<>();
	
	
	public PlayerStatusAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public PlayerStatus getPlayerStatus(ClientId client) throws RemoteException {
		return playerStatuses.get(client.getId());
	}

	@Override
	public void setPlayerStatus(ClientId client, PlayerStatus status) throws RemoteException {
		playerStatuses.put(client.getId(), status);
	}

}
