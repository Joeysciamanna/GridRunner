package ch.g_7.gridRunner.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import ch.g_7.gridRunner.server.game.GameAgentImpl;
import ch.g_7.gridRunner.server.id.ClientIdAgentImpl;
import ch.g_7.gridRunner.server.playerStatus.PlayerStatusAgentImpl;

public class GridRunnerServer {

	private static final long serialVersionUID = 1L;
	private static Registry registry;

	public static void main(String[] args) {
		try {

			registry = LocateRegistry.createRegistry(1109);

			registry.rebind(Agent.GAME.getName(), new GameAgentImpl());

			registry.rebind(Agent.PLAYER_STATUS.getName(), new PlayerStatusAgentImpl());

			registry.rebind(Agent.CLIENT_ID.getName(), new ClientIdAgentImpl());

			System.err.println("---SERVER READY---\n");

		} catch (Exception e) {

			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();

		}

	}

}
