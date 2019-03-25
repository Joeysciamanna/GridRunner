package ch.g_7.gridRunner.connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.g_7.gridRunner.server.agent.Agents;
import ch.g_7.gridRunner.server.clientId.ClientIdProviderAgent;
import ch.g_7.gridRunner.server.lobbyProvider.LobbyProviderAgent;

public class ServerConnectionProvider {

private static final String DOMAIN = "rmi://localhost:1109/";
	
	private static ClientIdProviderAgent clientIdProviderAgent;
	private static LobbyProviderAgent lobbyProviderAgent;
	
	public static LobbyProviderAgent getLobbyProviderAgent() {
		if(lobbyProviderAgent==null) {
			lobbyProviderAgent = (LobbyProviderAgent) lookup(Agents.LOBBY_PROVIDER);
		}
		return lobbyProviderAgent;
	}

	public static ClientIdProviderAgent getClientIdAgent() {
		if(clientIdProviderAgent==null) {
			clientIdProviderAgent = (ClientIdProviderAgent) lookup(Agents.CLIENT_ID);
		}
		return clientIdProviderAgent;
	}
	
	public static Remote lookup(String name) {
		try {
			return Naming.lookup(DOMAIN+name);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Remote lookup(Agents agent) {
		try {
			return Naming.lookup(DOMAIN+agent.toString());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		}
	}
}
