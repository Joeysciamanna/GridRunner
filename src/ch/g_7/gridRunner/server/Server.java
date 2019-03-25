package ch.g_7.gridRunner.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridRunner.server.agent.Agent;
import ch.g_7.gridRunner.server.clientId.ClientIdProviderAgentImpl;
import ch.g_7.gridRunner.server.lobbyProvider.LobbyProviderAgentImpl;
import ch.g_7.logger.main.Level;
import ch.g_7.logger.main.Logger;
import ch.g_7.logger.streams.ConsolStream;

public class Server {

	private static Registry registry;
	private static final Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) {
		FieldCreationRegister.setDefaultFactory(new ServersideFieldFactory());
		LOGGER.register(new ConsolStream());
		try {
			registry = LocateRegistry.createRegistry(1109);
			bind(new LobbyProviderAgentImpl());
			bind(new ClientIdProviderAgentImpl());
		} catch (Exception e) {
			LOGGER.log(Level.EXCEPTION, e);
		}

	}
	
	public static void bind(Agent agent) {
		try {
			registry.rebind(agent.getName(), agent);
			LOGGER.log(Level.INFO, "Server bound " + agent.getName());
		} catch (RemoteException e) {
			LOGGER.log(Level.EXCEPTION, e);
		}
	}
	
	public static void unbind(Agent agent) {
		try {
			registry.unbind(agent.getName());
			LOGGER.log(Level.INFO, "Server unbound " + agent.getName());
		} catch (RemoteException | NotBoundException e) {
			LOGGER.log(Level.EXCEPTION, e);
		}
	}
}
