package ch.g_7.gridRunner.server.playerStatus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import ch.g_7.gridRunner.playerStatus.PlayerStatus;

public class PlayerStatusAgentImpl extends UnicastRemoteObject implements PlayerStatusAgent{

	private static final long serialVersionUID = 2027480092072051883L;
	Map<Long, PlayerStatus> playerStatuses = new HashMap<>();
	
	
	public PlayerStatusAgentImpl() throws RemoteException {
		super();
	}

	@Override
	public PlayerStatus getPlayerStatus(long id) throws RemoteException {
		return playerStatuses.get(id);
	}

	@Override
	public void setPlayerStatus(long id, PlayerStatus status) throws RemoteException {
		playerStatuses.put(id, status);
	}

}
