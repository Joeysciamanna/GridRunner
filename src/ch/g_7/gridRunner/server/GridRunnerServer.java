package ch.g_7.gridRunner.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import ch.g_7.gridRunner.server.controller.ControllerAgentImpl;
import ch.g_7.gridRunner.server.game.GameAgentImpl;
import ch.g_7.gridRunner.server.id.ClientIdAgentImpl;

public class GridRunnerServer extends UnicastRemoteObject{

	private static final long serialVersionUID = 1L;
	private static Registry registry;
	
	protected GridRunnerServer() throws RemoteException {
		try {

			registry = LocateRegistry.createRegistry(1109);
			
			registry.rebind(Agent.GAME.getName(), new GameAgentImpl());
			
			registry.rebind(Agent.CONTROLLER.getName(), new ControllerAgentImpl());
			
			registry.rebind(Agent.CLIENT_ID.getName(), new ClientIdAgentImpl());
			
			System.err.println("---SERVER READY---\n");	
			
		} catch (Exception e) {

			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		try {
			GridRunnerServer gridRunnerServer = new GridRunnerServer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
