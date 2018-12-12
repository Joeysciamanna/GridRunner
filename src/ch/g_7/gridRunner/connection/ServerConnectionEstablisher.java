package ch.g_7.gridRunner.connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import ch.g_7.gridRunner.server.Agent;
import ch.g_7.gridRunner.server.game.GameAgent;
import ch.g_7.gridRunner.server.id.ClientIdAgent;
import ch.g_7.gridRunner.server.playerStatus.PlayerStatusAgent;

public class ServerConnectionEstablisher{

	private static final String DOMAIN = "rmi://192.168.1.114:1109/";
	
	private static GameAgent gameAgent;
	private static PlayerStatusAgent playerStatusAgent;
	private static ClientIdAgent clientIdAgent;
	
	public static PlayerStatusAgent getPlayerStatusAgent() throws RemoteException, NotBoundException {
		if(playerStatusAgent==null) {
			try {
				playerStatusAgent = (PlayerStatusAgent) Naming.lookup(DOMAIN+Agent.PLAYER_STATUS.getName());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return playerStatusAgent;
	}
	
	public static GameAgent getGameAgent() throws RemoteException, NotBoundException {
		if(gameAgent==null) {
			try {
				gameAgent = (GameAgent) Naming.lookup(DOMAIN+Agent.GAME.getName());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return gameAgent;
	}
	
	public static ClientIdAgent getClientIdAgent() throws RemoteException, NotBoundException {
		if(clientIdAgent==null) {
			try {
				clientIdAgent = (ClientIdAgent) Naming.lookup(DOMAIN+Agent.CLIENT_ID.getName());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return clientIdAgent;
	}
}
